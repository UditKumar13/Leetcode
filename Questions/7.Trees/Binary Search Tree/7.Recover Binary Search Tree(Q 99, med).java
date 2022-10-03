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
    int breakingCond = 0;
    TreeNode firstEle = null,secondEle = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstEle.val;
        firstEle.val = secondEle.val;
        secondEle.val = temp;
        
    }
    
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        
        if(firstEle == null && prev.val > root.val){
            firstEle = prev;
        }
        
        if(firstEle != null && prev.val > root.val){
            secondEle = root;
            breakingCond++;
            if(breakingCond == 2) return;
        }
        
        
        prev = root;
        traverse(root.right);
    }
}