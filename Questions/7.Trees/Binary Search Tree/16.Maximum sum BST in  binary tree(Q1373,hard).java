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
    int maxSum = 0;
    class Pair{
        int min;
        int max;
        int sum;
        
        Pair(int _min, int _max, int _sum){
            this.min = _min;
            this.max = _max;
            this.sum = _sum;
        }
    }
    
    
    public Pair traverse(TreeNode root){
        if(root == null){
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
            // min, max, sum :  +infinity, -infinity, 0 
        }
        
        Pair left = traverse(root.left);
        Pair right = traverse(root.right);
        
        if(left == null || right == null){
            return null;
        }
        
        if(root.val <=left.max || root.val >= right.min){
            return null;
        }
        
        maxSum = Math.max(maxSum,root.val + left.sum + right.sum);
        int myMin = Math.min(root.val,left.min);
        int myMax = Math.max(root.val,right.max);
        return new Pair(myMin,myMax,root.val+left.sum+right.sum);
        
         
    }
                                                                                                                                                             

    public int maxSumBST(TreeNode root) {
        if(root == null) return 0;
        Pair give =traverse(root);
        return maxSum;
    }
}


// TC : O(n)
// SC : O(n)

