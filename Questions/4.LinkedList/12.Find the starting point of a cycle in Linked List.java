/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      
      
      // base case 
      
      if(head == null || head.next == null) return null ; 
       
      // step 1 find the meeting point of s and f
      
      ListNode slow = head  ;
      ListNode fast = head  ;
      
      while(fast != null && fast.next != null){
        slow = slow.next ; // 1 jump
        fast = fast.next.next ; // 2 jump 
        
        if (slow == fast) break ;
      }
      
      if(slow != fast) return null ; // no cycle 
      
      // now we are standing at the meeting point of slow and fast , keep slow there and update fast at head
      
      fast = head ; 
      
      while(fast != slow){
        fast = fast.next ; // both 1 jump
        slow = slow.next ;
        
        if (fast == slow )break ; 
      }
      return fast ; 
      
    }
}

// https://leetcode.com/problems/linked-list-cycle-ii/discuss/1701128/C%2B%2BJavaPython-Slow-and-Fast-oror-Image-Explanation-oror-Beginner-Friendly 