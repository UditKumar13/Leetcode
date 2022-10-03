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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        
        if(root.val >  val){
            root.left = insertIntoBST(root.left,val);
        }
        
        return root;
    }
}


// TC : O(n)

// SC : O(n)


// Approach 2 : Striver 

Iterative

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        
        while(true){
            if(curr.val <= val){
                if(curr.right !=null){
                   curr = curr.right; 
                }
                
                else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            
            else{
                if(curr.left !=null){
                   curr = curr.left; 
                }
                
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}



// Iterative 
// TC : O(n)

// SC: O(1)

