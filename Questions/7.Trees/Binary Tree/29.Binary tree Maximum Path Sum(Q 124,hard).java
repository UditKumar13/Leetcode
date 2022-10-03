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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        
      
    }
    
    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,maxSum(root.left));
        int right = Math.max(0,maxSum(root.right));
        max = Math.max(max,left + right + root.val);
        
        return Math.max(left,right)+ root.val;
        
    }
    

}


// this is not the right approach as you are using the global variable to store the final answer 


// Approach 2 
// how we can pass a parameter as a reference in java
 
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
    public int maxPathSum(TreeNode root) {
        int []maxValue = new int [1]; 
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root,maxValue); // single ele of arr passed as a reference
        return maxValue[0];
    }
    
    
    public int maxPath(TreeNode root, int []maxValue){
        if(root == null) return 0;
        int left  = Math.max(0,maxPath(root.left,maxValue));
        int right  = Math.max(0,maxPath(root.right,maxValue));
        
        maxValue[0] = Math.max(maxValue[0],left + right + root.val);
        return Math.max(left,right) + root.val; // for selecting only max single path // see the example 2
    }
    
    
}

// better appraoch 
// Always follow this approach 

