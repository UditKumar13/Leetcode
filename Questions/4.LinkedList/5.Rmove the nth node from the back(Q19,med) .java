/*

Optimal: Two Pointers with an N-gap (one pass)

Idea: Move fast pointer n steps ahead first. Then move slow and fast together until fast hits the end. slow now sits right before the node to remove — because the gap between them is always exactly n.
Time: O(L) — single pass. Space: O(1).
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move both until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now right before the node to remove
        slow.next = slow.next.next;

        return dummy.next;
    }
}


/*
in go  :
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    dummy := &ListNode{Next: head}
    slow, fast := dummy, dummy

    for i := 0; i < n; i++ {
        fast = fast.Next
    }

    for fast.Next != nil {
        slow = slow.Next
        fast = fast.Next
    }

    slow.Next = slow.Next.Next

    return dummy.Next
}
*/