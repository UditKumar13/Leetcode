class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node == null) return;
        doMirror(node);
    }
    
    void doMirror(Node node){
        if(node == null) return ;
        doMirror(node.left);
        doMirror(node.right);
        Node temp = node.right;
        node.right = node.left;
        node.left = temp;
        
    }
}