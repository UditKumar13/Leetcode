class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        
        int [] dp = new int [cost.length] ;
        int ans = 0 ; 
        for (int i = dp.length -1 ; i>=0 ; i--){
            if (i <=dp.length-3){
                  dp[i] = Math.min(cost[i] +dp[i+1], cost[i] + dp[i+2] );
            }
            else {
                dp[i] = cost[i] ; 
            }
          
        }
        
        ans = Math.min(dp[0],dp[1]) ; 
        return ans ; 
    }
}