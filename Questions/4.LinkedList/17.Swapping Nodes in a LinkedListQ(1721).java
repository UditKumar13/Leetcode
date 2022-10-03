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
    public ListNode swapNodes(ListNode head, int k) {
        int temp = k-1;
        int firstVal = 0;
        int secondVal = 0;
        ListNode curr = head;
        int idx = 0;
        ListNode fast = head;
        ListNode slow = head;
        
        while (curr != null){
            if (idx == k-1) firstVal = curr.val;
            if (idx >k-1){
                fast = fast.next;
                slow = slow.next;
            }
            else {
                fast = fast.next;
            }
            curr = curr.next;
            idx +=1;
        }
        int len = idx + 1;
        secondVal = slow.val;
        System.out.println(firstVal);
        System.out.println(secondVal);
        curr = head;
        idx = 0;
        while(curr != null){
            if (idx == k-1) curr.val = secondVal;
            if (idx == len-k-1) curr.val = firstVal; 
            
            curr = curr.next;
            idx += 1;
        }
        
        return head;
    }
}