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
  // 1 2 3 4 5  and k =2
    public ListNode reverseKGroup(ListNode head, int k) {
    
      // let us do the recursive program 
      
      ListNode curr = head ;
      
      int count = 0 ; // it will help us to handle the flow
      
      while(curr != null && count != k){
        curr = curr.next ; 
        count ++ ; 
      }
      
      
      if (count == k ){
        
        curr = reverseKGroup(curr,k) ; // updating the curr curr = 5 // recusrive call 
        // work is done in post order
        
        while(count -- > 0 ){
          // main logic 
          
          ListNode tmp = head.next ; // tmp =4
          head.next = curr ; // 3 se 5 connect hogaa
          curr = head ; // curr badalta hai aab 3 ko curr bnao because curr se hi link bnana hai
          head = tmp ; // 4 ko head bnao aab because 4 se 3 link hoga next
          
        }
        
        
        
        head = curr ; 
        
      }
      
      
     
    return head ; 
  }
}
