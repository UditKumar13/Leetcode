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

//Brute force 

TC : O(1) GIVEN functions and SC : O(n) SPACE 
class BSTIterator {
    List<Integer> inorder = new ArrayList<Integer>();
    TreeNode ptr;
    int idx = 0;
     BSTIterator(TreeNode root){
            this.ptr = root;
            inorder.add(Integer.MIN_VALUE);
            fill(ptr);
        }
    public void fill(TreeNode root){
        if(root == null) return;
        fill(root.left);
        inorder.add(root.val);
        fill(root.right);
    }
    
    
    public int next() {
        
        return inorder.get(++idx);
    
    }
    
    public boolean hasNext() {
        if(idx+1 <inorder.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */