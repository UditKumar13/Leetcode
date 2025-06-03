// recursion solution 
// top down approach
class Solution {
    public int coinChange(int[] coins, int Target) {
        int n  = coins.length;
        if(n == 1){
          if(coins[0] % Target == 0) return coins[0]/Target;
          else return -1;
        }
      int min_coins = recursion(coins, Target, coins.length-1);
      if(min_coins >= (int)1e9) return -1;
      return min_coins;
  }
  
  public int recursion(int[] coins, int rem_amount, int idx){
    if(idx == 0){
      if(rem_amount % coins[idx] == 0) return rem_amount / coins[idx];
      else return (int)1e9;
    }
    int not_take = 0 + recursion(coins, rem_amount, idx-1);
    int take = Integer.MAX_VALUE;
    if(coins[idx] <= rem_amount){
      take = 1 + recursion(coins, rem_amount - coins[idx], idx); // idx still remains same because we can take the same coin again
    }
    return Math.min(take, not_take);
  }
}

// memoization approach

class Solution {
    public int coinChange(int[] coins, int Target) {
        int n  = coins.length;
        if(n == 1){
          if(Target % coins[0] == 0) return Target/coins[0];
          else return -1;
        }
      int [][]dp = new int[coins.length][Target+1];
      for(int []each_row : dp){
        Arrays.fill(each_row, -1);
      }
      int min_coins = recursion(coins, Target, coins.length-1, dp);
      if(min_coins >= (int)1e9) return -1;
      return min_coins;
  }
  
  public int recursion(int[] coins, int rem_amount, int idx, int [][]dp){
    if(idx == 0){
      if(rem_amount % coins[idx] == 0) return rem_amount / coins[idx];
      else return (int)1e9;
    }
    if(dp[idx][rem_amount] != -1) return dp[idx][rem_amount];
    int not_take = 0 + recursion(coins, rem_amount, idx-1, dp);
    int take = Integer.MAX_VALUE;
    if(coins[idx] <= rem_amount){
      take = 1 + recursion(coins, rem_amount - coins[idx], idx, dp);
    }
    return dp[idx][rem_amount] = Math.min(take, not_take);
  }
}

//TC: O(coins.length*Target)
//SC: O(coins.length*Target) + O(coins.length + Target) for recursion stack space

//memo  to tabulation 
// Bottom up Technique : 
class Solution {
    public int coinChange(int[] coins, int Target) {
        int n  = coins.length;
        int [][]dp = new int[coins.length][Target+1];
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }
        // base case 
        for(int T=0; T<=Target; T++){
           if(T % coins[0] == 0) dp[0][T] = T/coins[0];
           else dp[0][T] = (int)1e9;
       }
        for(int i=1;i<coins.length;i++){
            for(int T=0;T<= Target; T++){
                int not_take = dp[i-1][T];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= T) take = 1 + dp[i][T-coins[i]];
                dp[i][T] = Math.min(take, not_take);
            }
        }
        
        if(dp[n-1][Target] >= (int)1e9) return -1;
        return dp[n-1][Target];
  }
}

// TC(coins.length, Target)
// SC(coins.length, Target)