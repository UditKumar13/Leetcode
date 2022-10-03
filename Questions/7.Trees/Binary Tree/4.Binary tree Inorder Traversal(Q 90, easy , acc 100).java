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


// Recusive Approach 
class Solution {
    List<Integer> ans  = new ArrayList<>() ; 
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null ){
            return ans;
        }
        
        List<Integer> left  = inorderTraversal(root.left) ; 
        ans.add(root.val) ;
        List<Integer> right = inorderTraversal(root.right) ;
        
        return ans  ; 
    }
}

// Method 2
// Iterative appraoch 

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
     
         
     public List<Integer> inorderTraversal(TreeNode root) {
     // let us do the coding in the iterative way
         
        
         List<Integer> ans = new ArrayList<>() ;
         
         Deque<TreeNode> st  = new ArrayDeque<TreeNode>();
         TreeNode cur = root ;
         // root 
         
         while(cur != null || ! st.isEmpty()){
             while(cur != null){
                 st.push(cur);
                 
                 cur = cur.left ; // go to the left 
             }
// 3 steps // pop ,save , make curr right
             cur = st.pop();
             ans.add(cur.val);
             
             cur = cur.right ; 
             
             
         }
         
         return ans ; 
         
    }
    
}



2 while loop tricky 
1 outer loop 2 conditions 
1 inner loop curr != null 

