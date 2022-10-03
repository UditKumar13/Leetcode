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

  public ListNode rotateRight(ListNode head, int n) {
    if (head==null||head.next==null) return head;
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode fast=dummy,slow=dummy;

    int len;
    for (len=0;fast.next!=null;len++)//Get the total length 
    	fast=fast.next;
    
    for (int j=len-n%len ;j>0;j--) //Get the i-n%i th node
    	slow=slow.next;
    
    
    // logic 
    fast.next=head; // fast is at the end , so end ko link kro head se 
    dummy.next=slow.next; // dummy ka next means starting point hoga slow ka next 
    slow.next=null; // slow.next null krdenge ye bnega end 
    
    return dummy.next;
}
  
}