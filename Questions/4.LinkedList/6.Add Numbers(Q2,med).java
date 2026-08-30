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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}

// Time: O(max(m, n))

// Optimal: Digit-by-digit addition with carry (dummy node)

// Idea: Walk both lists simultaneously, add corresponding digits plus carry from the previous step, create a new node for sum % 10, and propagate sum / 10 as the new carry. Continue until both lists and the carry are exhausted.
// Time: O(max(m,n)) Space: O(max(m,n)) for the output (required, not extra).


/*
in go  :
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{}
    curr := dummy
    carry := 0

    for l1 != nil || l2 != nil || carry != 0 {
        x, y := 0, 0
        if l1 != nil {
            x = l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            y = l2.Val
            l2 = l2.Next
        }

        sum := x + y + carry
        carry = sum / 10
        curr.Next = &ListNode{Val: sum % 10}
        curr = curr.Next
    }

    return dummy.Next
}
*/