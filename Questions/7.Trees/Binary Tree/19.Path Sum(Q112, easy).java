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
    int sum =0;
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(ans == true) return true;
        sum += root.val;
        if(sum == targetSum && root.left == null && root.right == null) return true;
        
        boolean left =  hasPathSum(root.left,targetSum);
        
        boolean right = hasPathSum(root.right,targetSum);
        if(left || right) ans = true;
        sum -= root.val;
        return ans;
    }
}