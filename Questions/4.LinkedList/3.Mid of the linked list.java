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
    public ListNode middleNode(ListNode head) {
     
      
      if(head == null || head.next == null ){
        return head ;
      }
      ListNode slow = head;
      ListNode fast =head ; // initialize both of them to the starting 
      
      while( fast.next != null && fast.next.next != null){
        fast  =fast.next.next ; 
        slow = slow.next ; 
        
      }
      
      if (fast.next == null){
       return slow ; 
      }
      
      else {
        slow = slow.next ;
        return slow ; 
      }
    }
}