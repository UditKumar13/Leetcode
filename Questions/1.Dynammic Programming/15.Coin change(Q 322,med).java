public class Solution {
public int coinChange(int[] coins, int amount) {
  
    int max = Integer.MAX_VALUE -1 ;
    int n = coins.length;
    
    int [][] dp = new int [n+1][amount + 1] ;
    
    for(int i=0,j=0;j<dp[0].length;j++){
        dp[i][j] = max;
    }
    
    for(int i=1,j=0;i<n+1;i++){
        dp[i][j] = 0;
    }
    
    // 2nd row
    
    for(int i=1,j=1;j<dp[0].length;j++){
        if(j% coins[i-1] == 0){
            dp[i][j] = j/coins[i-1];
        }
        else dp[i][j] = max; 
            
    }
    
    // rest of the dp 
    for(int i=2;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            if(coins[i-1] <=j ){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] + 1);
            }
            
            else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    return dp[n][amount] == max ? -1 : dp[n][amount];
}


}