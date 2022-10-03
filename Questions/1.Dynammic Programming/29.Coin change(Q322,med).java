public class Solution {
public int coinChange(int[] coins, int target) {
    int n = coins.length;
    int max = Integer.MAX_VALUE-1;
    
    int [][]dp = new int[n][target+1];
    for(int T=0;T<=target;T++){
        if(T % coins[0] == 0) dp[0][T] = T/coins[0];
        else dp[0][T] = max;
    }
    
    // base case 
    
    for(int idx =1; idx<n; idx++){
        for(int T=0; T<=target; T++){
            int notTake = 0 + dp[idx-1][T];
            int take = max;
            
            if(coins[idx] <=T){
                take = 1 + dp[idx][T-coins[idx]];
            }
            
            dp[idx][T] = Math.min(take,notTake);
        }
    }
    
    int minCoin = dp[n-1][target];
    if(minCoin >=max) return -1;
    return minCoin;
}
}

// Tc : O(n * T)

// Sc : O(n * T)



// Approach 2 :

space optimized 

public class Solution {
public int coinChange(int[] coins, int target) {
    int n = coins.length;
    int max = Integer.MAX_VALUE-1;
    int []prev = new int[target+1];
    int []curr = new int[target+1];
    for(int T=0;T<=target;T++){
        if(T % coins[0] == 0) prev[T] = T/coins[0];
        else prev[T] = max;
    }
    
    // base case 
    
    for(int idx =1; idx<n; idx++){
        for(int T=0; T<=target; T++){
            int notTake = 0 + prev[T];
            int take = max;
            
            if(coins[idx] <=T){
                take = 1 + curr[T-coins[idx]];
            }
            
            curr[T] = Math.min(take,notTake);
        }
        prev = curr;
    }
    
    int minCoin = prev[target];
    if(minCoin >=max) return -1;
    return minCoin;
}
}

// Tc : O(N * T)

// SC : O(2N)

only 2 rows prev and curr

