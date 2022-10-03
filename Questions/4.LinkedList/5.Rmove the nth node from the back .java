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
        
      
      ListNode h1 = head ;
      ListNode h2 = head ; 
      
      
      // we will traverse first n 
      
      while (n-- > 0 ) h2 = h2.next ;
      
      
      if (h2  == null ) return h1.next ; // think logically  
      h2 = h2.next; 
      // so now the len - n - 2 ditance is left that is the postion if we start incrementing the h1 will lead us to 
      // the prev ele that have to deleted logically 
      
      while(h2 != null ){
        h1 = h1.next ;
        h2 = h2.next ; 
      }
      
      // now h1 is at the prev pos 
      
      // so the real work begins now 
      
      h1 .next = h1.next.next ;
      
      return head ; 
      
    }
}