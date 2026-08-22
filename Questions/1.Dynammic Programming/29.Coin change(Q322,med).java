
/*

brute force in go : 

func coinChange(coins []int, amount int) int {
    result := helper(coins, amount)
    if result == math.MaxInt32 {
        return -1
    }
    return result
}
func helper(coins []int, amount int) int {
    if amount == 0 {
        return 0
    }
    if amount < 0 {
        return math.MaxInt32
    }
    best := math.MaxInt32
    for _, coin := range coins {
        sub := helper(coins, amount-coin)
        if sub != math.MaxInt32 && sub+1 < best {
            best = sub + 1
        }
    }
    return best
}

*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE; // invalid path
        
        int best = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = helper(coins, amount - coin);
            if (sub != Integer.MAX_VALUE) {
                best = Math.min(best, sub + 1);
            }
        }
        return best;
    }
}

// Time : O(coins.length ^ amount) | Space : O(amount) (for the recursion stack)

class Solution {
    private int[] memo;
    
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2); // -2 = "not computed yet" (distinct from -1 = "impossible")
        int result = helper(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != -2) return memo[amount];
        
        int best = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = helper(coins, amount - coin);
            if (sub != Integer.MAX_VALUE) {
                best = Math.min(best, sub + 1);
            }
        }
        memo[amount] = best;
        return best;
    }
}

// Time : O(coins.length * amount) | Space : O(amount) (for the memoization array + recursion stack)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // "infinity" sentinel — amount+1 coins is never achievable
        dp[0] = 0;
        
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// Time : O(coins.length * amount) | Space : O(amount) (for the dp array)


