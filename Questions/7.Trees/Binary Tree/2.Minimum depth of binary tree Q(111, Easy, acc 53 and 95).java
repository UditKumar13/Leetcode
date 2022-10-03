
// DFS solution 9ms  53 % time 
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
    public int minDepth(TreeNode root) {
        
     
       if (root == null)   return 0; 
        
        int left = minDepth(root.left) ;
        int right = minDepth(root.right) ;
    
        
        
        return (left ==0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1 ; 
        // last step is tricky and logical 
        // if any of the left or right is 0, we can't take minimum beacuse 0 will return everytime from the minimum and 1 will return 
        // that will be wrong, so we have two make two cases, if any of the left or right is  , we say left + right + 1 and second case if not, then take min (left,right) then add 1
        
        
    }
}


// Better Method  95 % runtime 
// Bfs Solution 1ms 

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
    public int minDepth(TreeNode root) {

        
         // let us implement the bfs strategy to find the depth 
        if (root == null ) return  0;
        
        Queue<TreeNode> q = new LinkedList<>()  ;
        
        // this is the Queue of TreeNode structure 
        q.offer(root) ; // root is inserted 
        
        int depth  = 1 ;
        
        while(!q.isEmpty()){
            
            int size = q.size()  ;
            
            while (size-- > 0){
                TreeNode curr = q.poll() ;  // first phle niklta hai 
                if (curr.left == null && curr.right == null) return depth; // we are at 
                // leaf node 
                
                if (curr.left !=null ) 
                    q.offer(curr.left) ; 
                if (curr.right != null) 
                    q.offer(curr.right) ; 
            }
            depth += 1 ; // after each level traversal inrease the depth by 1 
            // go to next level 
            
        }
        
        return  -1 ; // unreachable 
    }
}