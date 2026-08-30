/*
Optimal: Min-Heap (Priority Queue)

Idea: Put the head node of each of the k lists into a min-heap, keyed by value. Repeatedly pop the smallest, attach it to your result, and push its next node (if any) back into the heap. This is LC 21's two-pointer merge generalized to k pointers using a heap to always know which pointer is smallest.
Time: O(N log k) — N total nodes, each heap push/pop is O(log k). Space: O(k) for the heap.

Java (class Solution format):
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time: O(N log k) — N total nodes, each pushed/popped from heap of size k
// Space: O(k) — heap only holds k nodes at a time


class Solution {
public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    ListNode result = lists[0];
    for (int i = 1; i < lists.length; i++) {
        result = mergeTwoLists(result, lists[i]);
    }
    return result;
}

private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
}

/*
optimal in java
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // seed the heap with each list's head
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                heap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}

/*
Optimal: Min-Heap (Priority Queue)

Idea: Put the head node of each of the k lists into a min-heap, keyed by value. Repeatedly pop the smallest, attach it to your result, and push its next node (if any) back into the heap. This is LC 21's two-pointer merge generalized to k pointers using a heap to always know which pointer is smallest.
Time: O(N log k) — N total nodes, each heap push/pop is O(log k). Space: O(k) for the heap.

Java (class Solution format):
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // seed the heap with each list's head
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                heap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}