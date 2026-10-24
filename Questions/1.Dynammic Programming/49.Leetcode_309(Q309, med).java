class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, false);
    }

    private int helper(int[] prices, int day, boolean holding) {
        if (day >= prices.length) return 0; // >= because selling jumps to day + 2

        int skip = helper(prices, day + 1, holding); // do nothing today

        int act;
        if (holding) {
            act = prices[day] + helper(prices, day + 2, false); // sell, then cooldown (skip day + 1)
        } else {
            act = -prices[day] + helper(prices, day + 1, true); // buy
        }
        return Math.max(skip, act);
    }
}

// memo 

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2]; // [day][0 = not holding, 1 = holding]
        return helper(prices, 0, 0, memo);
    }

    private int helper(int[] prices, int day, int holding, Integer[][] memo) {
        if (day >= prices.length) return 0;
        if (memo[day][holding] != null) return memo[day][holding];

        int skip = helper(prices, day + 1, holding, memo);

        int act;
        if (holding == 1) {
            act = prices[day] + helper(prices, day + 2, 0, memo);
        } else {
            act = -prices[day] + helper(prices, day + 1, 1, memo);
        }
        return memo[day][holding] = Math.max(skip, act);
    }
}

// Complexity: O(n) time, O(n) space for memo + O(n) recursion stack.

// 3. Tabulation: Bottom-Up DP

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        // dp[n][*] = dp[n+1][*] = 0 by default: no days left

        for (int day = n - 1; day >= 0; day--) {
            // not holding: skip, or buy
            dp[day][0] = Math.max(dp[day + 1][0], -prices[day] + dp[day + 1][1]);
            // holding: skip, or sell (cooldown means jump to day + 2)
            dp[day][1] = Math.max(dp[day + 1][1], prices[day] + dp[day + 2][0]);
        }
        return dp[0][0];
    }
}

// Complexity: O(n) time, O(n) space.

