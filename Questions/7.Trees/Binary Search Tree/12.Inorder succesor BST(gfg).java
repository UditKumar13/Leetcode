class Solution {
  public TreeNode inorderSuccesor(TreeNode root, TreeNode p){
      TreeNode successor = null;
      
      while(root != null){
          if(root.val <= p.val) root = root.right;
          
          else {
              successor = root;
              root = root.left;
          }
      }
      
      return sucessor;
  }
}

Tc : O(h)
SC : O(1)