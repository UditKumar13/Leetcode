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
    
    public int f(int idx, int w, int []weight, int[] val){
        if(idx == 0){
            if(wt[0] <=w) return val[0];
            return 0;
        }
        // base case 
        
        int notTake = 0 + f(idx-1,w,weight,val);
        
        int take = Integer.MIN_VALUE;
        
        if(wt[idx] <= w){
           take = 1 + f(idx-1,w-val[idx],weight,val); 
        }
       
        
        return Math.max(take,notTake);
    }
    
    public int knapSack(int []wt, int []val, int n,int maxWeight) {
        
        return f(n-1,w,weight,val);
    }
}


// Approach 1 

Recursive approach 


// Approach 2 

Memo :

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
    
    public int f(int idx, int w, int []weight, int[] val,int [][]dp){
        if(idx == 0){
            if(wt[0] <=w) return val[0];
            return 0;
        }
        // base case 
        if(dp[idx][w] != -1) return dp[idx][w];
        int notTake = 0 + f(idx-1,w,weight,val,dp);
        
        int take = Integer.MIN_VALUE;
        
        if(wt[idx] <= w){
           take = 1 + f(idx-1,w-val[idx],weight,val,dp); 
        }
       
        
        return dp[idx][w] = Math.max(take,notTake);
    }
    
    public int knapSack(int []wt, int []val, int n,int maxWeight) {
        int [][]dp = new int[n][maxWeight+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,w,weight,val,dp);
    }
}



// Approach 3 :

// Tabulation 
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
    
    public int f(int idx, int w, int []weight, int[] val,int [][]dp){
        if(idx == 0){
            if(wt[0] <=w) return val[0];
            return 0;
        }
        // base case 
        if(dp[idx][w] != -1) return dp[idx][w];
        int notTake = 0 + f(idx-1,w,weight,val,dp);
        
        int take = Integer.MIN_VALUE;
        
        if(wt[idx] <= w){
           take = 1 + f(idx-1,w-val[idx],weight,val,dp); 
        }
       
        
        return dp[idx][w] = Math.max(take,notTake);
    }
    
    public int knapSack(int []wt, int []val, int n,int maxWeight) {
        int [][]dp = new int[n][maxWeight+1];
        for(int w = wt[0]; w <= maxWeight; w++) dp[0][w] = val[0];
        
        
        for(int idx =1; idx<n; idx++){
            for(int W=0; W<maxWeight; W++){
            
                int notTake = dp[idx-1][W];
                int take = Integer.MIN_VALUE;
                if(wt[idx] <= W){
                   take = val[idx]+ dp[idx-1][W - wt[idx]]; 
                }
                
                dp[idx][W] = Math.max(take,notTake);
            }
        }
        
        return dp[n-1][maxWeight];
    }
}

// Approach 4 :


 only 2 row required 

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
    public int knapSack(int []wt, int []val, int n,int maxWeight) {
        int []prev = new int[maxWeight+1];
        int []curr = new int[maxWeight+1];
        
        for(int w = wt[0]; w <= maxWeight; w++) prev[w] = val[0];
        
        
        for(int idx =1; idx<n; idx++){
            for(int W=0; W<maxWeight; W++){
            
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if(wt[idx] <= W){
                   take = val[idx]+ prev[W - wt[idx]]; 
                }
                
                curr[W] = Math.max(take,notTake);
            }
            prev = curr;
        }
        
        return prev[maxWeight];
    }
}


// Approach 5 :

single 1 d array space optimization by changing the direction of filling

    }
 * }
 */
class Solution {
    public int knapSack(int []wt, int []val, int n,int maxWeight) {
        int []prev = new int[maxWeight+1];
        int []curr = new int[maxWeight+1];
        
        for(int w = wt[0]; w <= maxWeight; w++) prev[w] = val[0];
        
        
        for(int idx =1; idx<n; idx++){
            for(int W=maxWeight; W>=0; W--){
            
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if(wt[idx] <= W){
                   take = val[idx]+ prev[W - wt[idx]]; 
                }
                
                prev[W] = Math.max(take,notTake);
            }
        
        }
        
        return prev[maxWeight];
    }
}


