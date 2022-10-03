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
    public boolean isPalindrome(ListNode head) {
    
    // the approcah is to get the middle first 
      
    // we will use the strategy, of 2 pointers
      
    ListNode fast = head , slow = head ;
      
    while(fast != null && fast.next != null){
      slow = slow.next ; // 1 jump
      fast = fast.next.next ; // 2 jump
      
    }
    
      // for handling if the  linked list is of odd length 
       
      if(fast != null){
        // move slow 1 more 
        slow = slow.next ; 
      }
      
      
      // now slow will at the middle +1 ,starting of the right half
      
      // we have to reverse this right half 
      slow = reverse(slow) ;
      fast = head ; 
      
      while(slow != null){
        if (slow.val != fast.val){
          return false ; // not a palindrome 
        }
        
        slow = slow.next ; 
        fast = fast.next ; 
      }
      
      return true ; // yes this is a palindrome 
  }
  
  public ListNode reverse(ListNode head){
  
  ListNode prev = null ;
    
    while(head != null){
      ListNode next = head.next ; 
      head.next = prev ;
      prev = head ; 
      head = next ; 
    }
    return prev ; 
  }
}