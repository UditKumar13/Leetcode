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
    
     // Level order traversal 
    private int sum = 0, lastLevel = 0;
    public int deepestLeavesSum(TreeNode root) { 
    if (root == null) return 0;
     makeSum(root,0);
     return sum;
    }

    public void makeSum(TreeNode root, int level){
        if(root == null) return;
        if(level > lastLevel){
            sum = 0;
            lastLevel = level;
        }
        
        if(level == lastLevel){
            sum += root.val;
        }
        
        makeSum(root.left,level+1);
        makeSum(root.right,level+1);
    
    }
    
}