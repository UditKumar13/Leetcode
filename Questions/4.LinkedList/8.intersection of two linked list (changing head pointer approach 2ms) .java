/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// 2 ms approach 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
      
      if(headA == null || headB==null) return null ;
      
      ListNode a = headA ; 
      ListNode b = headB ;
      
      while(a != b){
         a = a==null ? headB : a.next;  // if we are at the end change the head of a to b
         b = b==null ? headA :b.next;  // or if we are not at the end, just increment the pointer
        
      }
      
      return b ; 
    }
}