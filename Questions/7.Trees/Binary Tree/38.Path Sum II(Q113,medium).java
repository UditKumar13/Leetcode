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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans =new ArrayList<>();
        if(root == null) return ans;
        helper(root,ans,targetSum,new ArrayList<>());
        return ans;
    }

    public void helper(TreeNode root, List<List<Integer>> ans,int sum,List<Integer>li){
        if(root == null){
            return;
        }
        li.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            ans.add(new ArrayList<>(li));
        }else{
        helper(root.left,ans,sum-root.val,li);
        helper(root.right,ans,sum-root.val,li);
        }
       
        li.remove(li.size()-1);


    }
}