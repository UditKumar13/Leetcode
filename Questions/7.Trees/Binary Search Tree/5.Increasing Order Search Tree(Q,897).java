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
    List<Integer>nodes = new ArrayList<>();
    
    public void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
    inorder(root);
    TreeNode iost = new TreeNode(nodes.get(0),null,null);
        TreeNode give = iost;
    for(int i =1; i<nodes.size();i++){
    TreeNode curr = new TreeNode(nodes.get(i),null,null);
    iost.right = curr;
    iost = curr;
    }
    return give;
}
}