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
    public ListNode reverseList(ListNode head) {
        
      // recursive solution 
      
      return reverse ( head, null) ; 
      
        
      }
      
   public ListNode reverse(ListNode head, ListNode newHead){
     
     
     if(head == null ){
       return newHead ; 
     }
     else {
       
       ListNode next = head.next ;
       head.next = newHead ; 
      return reverse(next,head) ; 
     }
     

   }
      
}
