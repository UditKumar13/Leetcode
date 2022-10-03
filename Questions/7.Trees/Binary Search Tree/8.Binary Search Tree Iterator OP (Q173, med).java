/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

Tc : O(1) SC : O(h)
class BSTIterator {
    TreeNode ptr;
    Stack <TreeNode> st = new Stack<>();
    
     BSTIterator(TreeNode root){
         ptr = root;
        fillAllLeft(ptr);
        }
    
    public void fillAllLeft(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    
    
    public int next() {
        TreeNode root = st.pop();
        fillAllLeft(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
       boolean val = st.size()>0 ? true : false;
       return val;  
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */