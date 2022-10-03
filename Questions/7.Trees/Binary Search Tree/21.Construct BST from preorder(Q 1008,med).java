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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstPreOrder(preorder,Integer.MAX_VALUE,new int []{0});
    }
    
    public TreeNode bstPreOrder(int[] preOrder,int limit,int [] arr){
        if(arr[0] == preOrder.length || preOrder[arr[0]] > limit) return null;
        
        TreeNode root = new TreeNode(preOrder[arr[0]++]);
        root.left = bstPreOrder(preOrder,root.val,arr);
        root.right = bstPreOrder(preOrder,limit,arr);
        return root;
    }
}



//TC : O(3n)  == O(n)

// SC : O(1)

