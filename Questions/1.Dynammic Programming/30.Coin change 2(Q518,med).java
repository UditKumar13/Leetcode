class Solution {
    public int change(int target, int[] coins) {
        int n  = coins.length;
        int max = Integer.MAX_VALUE;
        int [][]dp = new int[n][target+1];
        for(int T=0;T<=target;T++){
            if(T % coins[0] == 0) dp[0][T] = 1;
            else dp[0][T] = 0;
        }
        for(int i=1;i<n;i++){
            for(int T =0;T<=target;T++){
                int notTake = 0 + dp[i-1][T];
                int take = 0;
                if(coins[i] <= T) take = dp[i][T - coins[i]];
                dp[i][T] = notTake + take;
            }
        }
        return dp[n-1][target];
    }
}

// Approach 1 : 

// TC :O(n*T)
// SC :O(n*T)



// Approach 2 :
class Solution {
    public int change(int target, int[] coins) {
        int n  = coins.length;
        int max = Integer.MAX_VALUE;
        int []prev = new int[target+1];
        int []curr = new int[target+1];
        for(int T=0;T<=target;T++){
            if(T % coins[0] == 0) prev[T] = 1;
            else prev[T] = 0;
        }
        for(int i=1;i<n;i++){
            for(int T =0;T<=target;T++){
                int notTake = 0 + prev[T];
                int take = 0;
                if(coins[i] <= T) take = curr[T - coins[i]];
                curr[T] = notTake + take;
            }
            prev = curr;
        }
        return prev[target];
    }
}

// TC : O(n * T)

// sc : O(2*T)

space complexity optimized
