import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/*
Simple version for interviews — no DelayQueue, no per-task backoff math.

Idea: 2 queues.
  1. taskQueue   -> main priority queue, workers pull from here and execute.
  2. retryQueue  -> failed tasks land here (just a plain FIFO queue).

A single background thread wakes up every RETRY_INTERVAL_MS, drains
whatever is sitting in retryQueue, and dumps it back into taskQueue.
So instead of "retry this exact task in exactly 850ms" (DelayQueue),
it's "every 2 seconds, retry whatever failed so far" — much easier to
reason about and explain out loud.
*/

class Task implements Comparable<Task> {
    final long id;
    final int priority; // higher = more urgent
    final long sequenceNumber; // FIFO tiebreaker
    final Runnable work;
    volatile boolean cancelled = false;
    int retryCount = 0;

    Task(long id, int priority, long sequenceNumber, Runnable work) {
        this.id = id;
        this.priority = priority;
        this.sequenceNumber = sequenceNumber;
        this.work = work;
    }

    @Override
    public int compareTo(Task other) {
        int result = Integer.compare(other.priority, this.priority);
        if (result != 0) return result;
        // result == 0 that means priority is same, so we will use sequence number to maintain 
        // FIFO order
        // give ascending order to sequence number so that older tasks are executed first
        return Long.compare(this.sequenceNumber, other.sequenceNumber);
    }
}

class SimpleTaskScheduler {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_INTERVAL_MS = 2000; // check retryQueue every 2s

    private final PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>();
    private final BlockingQueue<Task> retryQueue = new LinkedBlockingQueue<>();
    private final Map<Long, Task> taskIndex = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);
    private final AtomicLong sequenceGenerator = new AtomicLong(0);
    private volatile boolean isShutdown = false;

    public SimpleTaskScheduler(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            new Thread(this::workerLoop).start();
            // new Thread(() -> workerLoop()).start(); 
            // // alternative lambda syntax

        }
        new Thread(this::retryLoop).start();
    }

    // ---- submit ----
    public long submit(Runnable work, int priority) {
        if (isShutdown) throw new RejectedExecutionException("Scheduler is shut down");
        long id = idGenerator.incrementAndGet();
        long seq = sequenceGenerator.incrementAndGet();
        Task task = new Task(id, priority, seq, work);
        taskIndex.put(id, task);
        taskQueue.put(task);
        return id;
    }

    // ---- cancel ----
    public boolean cancel(long taskId) {
        Task task = taskIndex.get(taskId);
        // we need hashmap to get the task object from the taskId 
        // in O(1) time that is why we are using hashmap to store the taskId
        //  and task object or if not we had to use a linear search in the taskQueue 
        // to find the task object which is O(n) time complexity

        if (task == null) return false;
        task.cancelled = true;
        return true;
    }

    public void shutdown() {
        isShutdown = true;
    }

    // ---- workers: pull from taskQueue, run, push failures to retryQueue ----
    private void workerLoop() {
        while (!isShutdown || !taskQueue.isEmpty()) {
            Task task;
            try {
                task = taskQueue.poll(500, TimeUnit.MILLISECONDS);
                // here the task which is polled is prioritized based on the 
                // priority and sequence number of the task given in compareTo method of
                //  Task class
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            if (task == null) continue;

            taskIndex.remove(task.id);
            if (task.cancelled) continue;

            try {
                task.work.run();
            } catch (Exception e) {
                task.retryCount++;
                if (task.retryCount > MAX_RETRIES) {
                    System.err.println("Dead-lettered task " + task.id + ": " + e.getMessage());
                } else {
                    retryQueue.offer(task);
                    // it will be retried in the next retryLoop cycle
                    // that is how we are using retryQueue to store the failed tasks
                    //  and retry them in the next cycle
                }
            }
        }
    }

    // ---- moves failed tasks from retryQueue back into taskQueue every RETRY_INTERVAL_MS ----
    private void retryLoop() {
        while (!isShutdown) {
            try {
                Thread.sleep(RETRY_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            List<Task> matured = new ArrayList<>();
            /*
            List<Task> matured = new ArrayList<>();
It's never stored in a field, never passed to another thread, never returned. Only the
 single retry-mover thread that's executing retryLoop() ever reads or writes this particular 
 ArrayList instance. Since retryLoop() runs on exactly one dedicated background thread
  (started once in the constructor, simple_task_scheduler.java:58:
   new Thread(this::retryLoop).start()), there's no concurrent access to 
   matured at all — no worker thread, no other caller ever touches it. 
   A plain ArrayList is perfectly safe here precisely because it's thread-local, 
   not shared.
            */
            retryQueue.drainTo(matured);
            // it drained all the tasks from the retryQueue to the matured list
            for (Task task : matured) {
                if (!task.cancelled) {
                    taskIndex.put(task.id, task);
                    taskQueue.put(task);
                }
            }
        }
    }
}

public class simple_task_scheduler {
    public static void main(String[] args) throws InterruptedException {
        SimpleTaskScheduler scheduler = new SimpleTaskScheduler(4);

        scheduler.submit(() -> System.out.println("Task A running"), 5);
        scheduler.submit(() -> {
            System.out.println("Task B running, about to fail");
            throw new RuntimeException("simulated failure");
        }, 10);
        long id3 = scheduler.submit(() -> System.out.println("Task C running"), 1);

        scheduler.cancel(id3);

        Thread.sleep(6000); // long enough to see at least one retry cycle

        scheduler.shutdown();
    }
}
