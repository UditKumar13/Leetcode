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
     List<Integer> ans = new ArrayList<>() ; 
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null )return ans;
        ans.add(root.val );
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        return ans ; 
        
    }
}


// iterative Intution 

root ko push krna hai
print krawaya top ele of stack 
stack ka top ko pop kro , check right first yes push, check left if yes push
 while mein krte jaao  


root print
right push 
left push 



     while (nodeStack.empty() == false) {
 
            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();
 
            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }
