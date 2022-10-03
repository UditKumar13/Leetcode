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

   public  class BSTPair{
        
        
    boolean isBST ; 
    long min ; 
    long max ; 
        
        
        
        
        public static BSTPair isBST (TreeNode node){
        
        if (node == null ){
            // we have to make 
            
           BSTPair bp = new BSTPair();
            
            bp.max = Long.MIN_VALUE ; 
            bp.min = Long.MAX_VALUE   ;
            bp.isBST = true ; 
            return bp ; 
        }
       
        //check the left side 
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        // now check for the root
        
        BSTPair bp= new BSTPair();
            
        bp.isBST = lp.isBST && rp.isBST && (node.val > lp.max) && (node.val < rp.min)  ;
            
        bp.min = Math.min(node.val , Math.min(lp.min,rp.min)) ; 
        bp.max= Math.max(node.val , Math.max(lp.max,rp.max) ) ;
            
        return bp ; 
        
        
        
        
        
    }
   
    }


class Solution extends BSTPair{
    
 
    
     
    
    public boolean  isValidBST(TreeNode root) {
    
      
     BSTPair ans = new BSTPair() ; 
    
    ans = isBST(root) ;
        
    return (ans.isBST) ; 
        
        
    }
}