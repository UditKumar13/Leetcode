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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length and tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Step 2: make circular
        tail.next = head;

        // Step 3: reduce k
        k = k % n;

        // Step 4: find new tail at position (n - k - 1)
        int stepsToNewTail = n - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

// Time: O(n)
// Space: O(1)

/*
Optimal: Make it Circular, then Break at the Right Point

Idea (exactly what your prep notes describe):

Walk to the tail, counting length n as you go.
Connect tail.next = head — the list is now circular.
Compute the effective rotation: k = k % n (handles k > n and k == n cleanly — rotating by a full length is a no-op).
The new tail is at position n - k - 1 from the old head. Walk there.
New head = newTail.next. Set newTail.next = null to break the circle.

Time: O(n) Space: O(1).
*/