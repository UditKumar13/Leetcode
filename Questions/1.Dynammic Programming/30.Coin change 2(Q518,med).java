// Coin Change II (LC 518): given coins and a target amount, count the number of distinct 
// combinations that make up that amount (unlimited supply of each coin). 
// Order doesn't matter — {1,2} and {2,1} are the same combination, counted once.

// This is the key trap: if you loop amount on the outside and coins on the inside 
// (like Coin Change I), you'll count 1+2 and 2+1 as different ways — that's permutations,
// not combinations. To count each combination exactly once, you must fix the coin loop on the outside. 
// This ordering subtlety is one of the most common places people trip up in interviews.



// concept : 

// Recurrence (with explicit coin index to avoid double-counting):

// helper(i, a) = helper(i+1, a) + helper(i, a - coins[i])

// helper(i+1, a) → don't use coin i anymore, move to next coin
// helper(i, a - coins[i]) → use coin i again (stay at same index, since unlimited supply)


// Base cases: helper(i, 0) = 1 (one way: use nothing more), 
// helper(i, a<0) = 0, helper(coins.length, a>0) = 0 (ran out of coins, amount not reached).


// brute force solution using recursion


class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount);
    }
    private int helper(int[] coins, int i, int amount) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;
        
        int skipCoin = helper(coins, i + 1, amount);       // move to next coin
        int useCoin = helper(coins, i, amount - coins[i]);  // reuse this coin
        return skipCoin + useCoin;
    }
}

// Time: O(coins.length ^ amount) | Space: O(amount) (for the recursion stack)


/*
func change(amount int, coins []int) int {
    return helper(coins, 0, amount)
}
func helper(coins []int, i, amount int) int {
    if amount == 0 {
        return 1
    }
    if amount < 0 || i == len(coins) {
        return 0
    }
    skipCoin := helper(coins, i+1, amount)
    useCoin := helper(coins, i, amount-coins[i])
    return skipCoin + useCoin
}
*/


// Notice the state here is a pair (i, amount) — that's different from Coin Change I,
//  which only needed amount. This is why the memo below needs 2 dimensions.



// top down 

class Solution {
    private Integer[][] memo;
    
    public int change(int amount, int[] coins) {
        memo = new Integer[coins.length][amount + 1];
        return helper(coins, 0, amount);
    }
    private int helper(int[] coins, int i, int amount) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;
        if (memo[i][amount] != null) return memo[i][amount];
        
        int skipCoin = helper(coins, i + 1, amount);
        int useCoin = helper(coins, i, amount - coins[i]);
        memo[i][amount] = skipCoin + useCoin;
        return memo[i][amount];
    }
}

// Time: O(coins.length * amount) | Space: O(coins.length * amount) (for the memoization array)

/*
in go : 
func change(amount int, coins []int) int {
    memo := make([][]int, len(coins))
    for i := range memo {
        memo[i] = make([]int, amount+1)
        for j := range memo[i] {
            memo[i][j] = -1 // -1 = "not computed" (valid answers are always >= 0)
        }
    }
    return helper(coins, 0, amount, memo)
}
func helper(coins []int, i, amount int, memo [][]int) int {
    if amount == 0 {
        return 1
    }
    if amount < 0 || i == len(coins) {
        return 0
    }
    if memo[i][amount] != -1 {
        return memo[i][amount]
    }
    skipCoin := helper(coins, i+1, amount, memo)
    useCoin := helper(coins, i, amount-coins[i], memo)
    memo[i][amount] = skipCoin + useCoin
    return memo[i][amount]
}
*/

// bottom up approach (tabulation)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1]; // dp[i][a] = ways to make `a` using coins[i:]
        
        // base case: dp[i][0] = 1 for all i (one way to make 0 — use nothing)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        
        // fill from i = n-1 down to 0 (mirrors recursion going from i to i+1)
        for (int i = n - 1; i >= 0; i--) {
            for (int a = 1; a <= amount; a++) {
                int skipCoin = dp[i + 1][a];
                int useCoin = (a - coins[i] >= 0) ? dp[i][a - coins[i]] : 0;
                dp[i][a] = skipCoin + useCoin;
            }
        }
        return dp[0][amount];
    }
}

// Bottom-Up (2D, mirrors top-down exactly) — O(coins × amount) time/space

/*
func change(amount int, coins []int) int {
    n := len(coins)
    dp := make([][]int, n+1)
    for i := range dp {
        dp[i] = make([]int, amount+1)
        dp[i][0] = 1
    }
    for i := n - 1; i >= 0; i-- {
        for a := 1; a <= amount; a++ {
            skipCoin := dp[i+1][a]
            useCoin := 0
            if a-coins[i] >= 0 {
                useCoin = dp[i][a-coins[i]]
            }
            dp[i][a] = skipCoin + useCoin
        }
    }
    return dp[0][amount]
}
*/

// optimal solution 1d array (space optimized)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case: one way to make amount 0
        
        for (int coin : coins) {           // outer loop: coin (this is what makes it "combinations")
            for (int a = coin; a <= amount; a++) {  // inner loop: amount, ascending
                dp[a] += dp[a - coin];
            }
        }
        return dp[amount];
    }
}

// Optimal (1D, space-compressed) — O(coins × amount) time, O(amount) space

// Since dp[i][a] only ever depends on dp[i+1][a] (same column, next row) and dp[i][a - coin]
//  (same row, earlier column), you can collapse to a single 1D array — processing coins one at
//   a time, in the outer loop, updating amounts left-to-right


