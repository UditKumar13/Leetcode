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
        
      // iterative solution 
      
      ListNode newNode = null ; 
      
      while(head != null ){
      
        ListNode next = head.next ; 
        
        head.next = newNode; // making the reverse connection 
        
        newNode  = head ;
        head = next ; 
        
      }
      
      return newNode; 
      
      
      
      
    }
}