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
    // let us calculate the length of the linked list
      
    int lena = cal_Len(headA);
    int lenb = cal_Len(headB);
      
    
    while(lena > lenb){
       
      headA = headA.next ; 
      lena -- ; 
    }
      
    while(lenb > lena){
      headB = headB.next ;
      lenb-- ;
    }
      
      
    while(headA != headB){
      headA = headA.next  ; 
      
      headB = headB.next ; 
    }
      
      return headA ;
    }
  
  
  
  public int cal_Len(ListNode lis) {
    int len = 0 ;
    
    while(lis != null){
      len++ ;
      
      lis = lis.next ; 
      
    }
    
    return len ; 
  }
}