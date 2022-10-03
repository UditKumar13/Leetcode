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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return checkMirror(root.left,root.right);
    }
    
    public boolean checkMirror(TreeNode x, TreeNode y){
        if(x == null && y == null) return true;
        if(x == null || y == null) return false;
        
        return (x.val == y.val) && checkMirror(x.left,y.right) && checkMirror(x.right,y.left);
    }
}