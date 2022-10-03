/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
         Queue <Node> que = new LinkedList<>();
        
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            Node nextRight = null;
            while(size-->0){
                Node head = que.poll();
                head.next = nextRight; // updation
                nextRight = head;
                if(head.right != null){
                    que.offer(head.right);
                }
                
                if(head.left != null){
                    que.offer(head.left);
                }
            }
        }
        return root;
    }
}