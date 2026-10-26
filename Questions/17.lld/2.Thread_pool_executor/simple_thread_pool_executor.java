import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
Simple version for interviews — fixed-size pool, unbounded queue, no
core/max sizing, no custom RejectedExecutionHandler strategies.

Idea: fixed set of worker threads, all pulling from one shared queue.
  1. workers   -> started once at construction time, never grow/shrink.
  2. taskQueue -> shared BlockingQueue<Runnable>; workers loop pulling from it.
  3. shutdown()    -> stop accepting new work, let queued tasks finish.
     shutdownNow() -> interrupt everyone now, hand back whatever's left queued.
*/

class Worker extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private final SimpleThreadPoolExecutor pool;

    Worker(BlockingQueue<Runnable> taskQueue, SimpleThreadPoolExecutor pool) {
        this.taskQueue = taskQueue;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (!pool.isShutdown() || !taskQueue.isEmpty()) {
            Runnable task;
            try {
                task = taskQueue.poll(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            if (task == null) continue;

            pool.activeCount.incrementAndGet();
            try {
                task.run();
            } catch (Exception e) {
                System.err.println("Task threw: " + e.getMessage());
            } finally {
                pool.activeCount.decrementAndGet();
                pool.completedCount.incrementAndGet();
            }
        }
    }
}

class SimpleThreadPoolExecutor {
    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final List<Worker> workers = new ArrayList<>();
    private volatile boolean isShutdown = false;

    final AtomicInteger activeCount = new AtomicInteger(0);
    final AtomicInteger completedCount = new AtomicInteger(0);

    public SimpleThreadPoolExecutor(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            Worker w = new Worker(taskQueue, this);
            workers.add(w);
            w.start();
        }
    }

    // ---- submit ----
    public void execute(Runnable task) {
        if (isShutdown) throw new RejectedExecutionException("Executor is shut down");
        taskQueue.offer(task);
    }

    public boolean isShutdown() {
        return isShutdown;
    }

    // graceful: stop accepting new tasks, let queued ones finish
    public void shutdown() {
        isShutdown = true;
    }

    // hard stop: interrupt all workers, hand back unfinished tasks
    public List<Runnable> shutdownNow() {
        isShutdown = true;
        List<Runnable> remaining = new ArrayList<>();
        taskQueue.drainTo(remaining);
        for (Worker w : workers) {
            w.interrupt();
        }
        return remaining;
    }

    public boolean awaitTermination(long timeoutMs) throws InterruptedException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        for (Worker w : workers) {
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0) return false;
            w.join(remaining);
        }
        for (Worker w : workers) {
            if (w.isAlive()) return false;
        }
        return true;
    }
}

public class simple_thread_pool_executor {
    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPoolExecutor pool = new SimpleThreadPoolExecutor(4);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            pool.execute(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                if (taskId == 3) throw new RuntimeException("simulated failure");
            });
        }

        pool.shutdown();
        pool.awaitTermination(5000);
        System.out.println("Completed: " + pool.completedCount.get());
    }
}
