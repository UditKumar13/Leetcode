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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head == null) return head;
        ListNode curr = head, prev = null, next = null;
        int pos = 1;
        while(curr != null){
            if(pos != left){
                prev = curr;
                curr = curr.next;
                pos++;
            }else{
                ListNode prevToleft = prev, leftNode = curr;
                while(pos<=right){
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    pos++;
                }
                ListNode afterTheRight = curr;
                leftNode.next = afterTheRight;
                
                if(prevToleft != null){
                    prevToleft.next = prev;
                    return head;
                }else{
                    // left was itself the head
                    return prev;
                }
            }
        }
        
        return head;
    }
}