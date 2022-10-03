// Recursive 

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
    List<Integer> postOrder = new ArrayList<>();
    
    public void postTraversal(TreeNode node){
        if(node == null) return;
        postTraversal(node.left);
        postTraversal(node.right);
        postOrder.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        
        postTraversal(root);
        return postOrder;
    }
}


// Iterative 

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

    public List<Integer> postorderTraversal(TreeNode root) {
 
    
        if (root == null) return li;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            li.addFirst(curr.val);
            
            if(curr.left != null){
                st.push(curr.left);
            }
            
            if(curr.right != null){
                st.push(curr.right);
            }
            
            
        }
        return li;       
    }
}