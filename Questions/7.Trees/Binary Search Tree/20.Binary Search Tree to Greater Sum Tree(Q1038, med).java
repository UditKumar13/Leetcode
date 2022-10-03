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
    
    public TreeNode bstToGst(TreeNode root) {
       if(root == null) return root;
        int [] arr = new int[1];
        arr[0] = 0;
        bstGst(root,arr);
        return root;
    }
    
    public void bstGst(TreeNode root, int[] sum){
        if(root == null) return;
        bstGst(root.right,sum);
        root.val += sum[0];
        sum[0] = root.val;
        bstGst(root.left,sum);
        
        
    }
}


// tc : O(n)

// sc : O(n)