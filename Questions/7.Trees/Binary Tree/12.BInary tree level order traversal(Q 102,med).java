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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue <TreeNode> myQ = new LinkedList<>();
        myQ.offer(root); // head ko add krdiya 
        
        while(!myQ.isEmpty()){
            List <Integer> currLevelNodes = new ArrayList<>();
            int size = myQ.size();
            for(int i=0;i<size;i++){
            TreeNode temp = myQ.remove(); // root ko remove krdiya 
            if(temp.left != null){
                myQ.offer(temp.left);
            }
                
            if(temp.right != null){
                myQ.offer(temp.right);
            }
                
            currLevelNodes.add(temp.val);
            } // for loop over
            
            ans.add(currLevelNodes);
        } // while loop
        
        return ans;
    }
  
        
    }
