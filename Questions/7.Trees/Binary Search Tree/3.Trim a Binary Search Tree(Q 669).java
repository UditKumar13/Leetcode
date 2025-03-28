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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;
        if(root.val < low){
            return trimBST(root.right, low, high); 
            // agar root hi uss range mein nhi toh left waale kahan se honge
            // we will focus only on right
        }if(root.val  > high){
            return trimBST(root.left, low, high);
            // agar root hi uss range mein nhi toh right waale kahan se honge
            // we will focus only on left
        }
        // if root is right we will take care of left and right and then return a
        // the root
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}