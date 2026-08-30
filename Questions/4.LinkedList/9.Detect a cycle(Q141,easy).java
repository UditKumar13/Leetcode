// brute force in go 
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// func hasCycle(head *ListNode) bool {
//     seen := make(map[*ListNode]bool)

//     for curr := head; curr != nil; curr = curr.Next {
//         if seen[curr] == true {
//             return true
//         }
//         seen[curr] = true;

//     }
//     return false
// }


// optimal 
// func hasCycle(head *ListNode) bool {
//     slow, fast := head, head

//     for fast != nil && fast.Next != nil {
//         slow = slow.Next
//         fast = fast.Next.Next
//         if slow == fast {
//             return true
//         }
//     }
//     return false
// }


// optimal in java 


// Step 3 — Floyd's Cycle Detection (Tortoise & Hare):
// Two pointers — slow moves 1 step at a time, fast moves 2 steps. If they ever point to the same node, there's a cycle. If fast or fast.next becomes null, no cycle.

// TC: O(n) | SC: O(1) ✅

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
