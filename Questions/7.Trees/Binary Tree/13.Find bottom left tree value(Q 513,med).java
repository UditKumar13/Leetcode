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
    int data = 0;
    public int findBottomLeftValue(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            root = q.remove();
            // call on the right first 
            if(root.right != null){
                q.offer(root.right);
            }
            
            if(root.left != null){
                q.offer(root.left);
            }
        }
        
        return root.val;
    }
 
}


// Tc O(n)
// sc O(n)

intution is that we will do the bfs, from right to left, 
because we want the deepest left most element 

// that's why you should go for the Reverse

// Intution : humko left waale mein max depth btani hai,so mujhe chahiye ki queue mein m left waale se last mein puchun
so is liye 
Right ko phle push kro
then left waale ko 
bcz queue is FIFO first in first out :
