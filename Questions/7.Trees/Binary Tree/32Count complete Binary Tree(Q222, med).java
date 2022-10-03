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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if(lh == rh) return (1<<lh) - 1;
        
        else 
        return countNodes(root.left) + countNodes(root.right) + 1;
        
    }
    
    public int getLeftHeight(TreeNode root){
        int count = 1;
        if(root == null) return count;
        
        while(root.left != null){
            count++;
            root = root.left;
        }
        
        return count;
    }
    
    public int getRightHeight(TreeNode root){
        int count = 1;
        if(root == null) return count;
        
        while(root.right != null){
            count++;
            root = root.right;
        }
        
        return count;
    }
    
 
}


// Tc :
// everytime we are calaulating the logn computation for the height 
// In the worst case left can move to the logn time 

// so complexity can be O(logn * logn)


// SC : (O(logn))
