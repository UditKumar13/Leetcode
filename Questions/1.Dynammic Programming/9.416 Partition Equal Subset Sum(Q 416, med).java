class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        return helper(nums, 0, target);
    }

    private boolean helper(int[] nums, int index, int remaining) {
        if (remaining == 0) return true;                     // hit target exactly
        if (index == nums.length || remaining < 0) return false; // ran out or overshot

        boolean take = helper(nums, index + 1, remaining - nums[index]); // include this number
        boolean skip = helper(nums, index + 1, remaining);               // exclude this number
        return take || skip;
    }
}

// brute force: O(2^n) time, O(n) space for recursion stack

// memo 

// 2. Memoization — Top-Down DP

// Cache on (index, remaining). Since remaining can range 0..target, use a 2D memo table.

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target, memo);
    }

    private boolean helper(int[] nums, int index, int remaining, Boolean[][] memo) {
        if (remaining == 0) return true;
        if (index == nums.length || remaining < 0) return false;
        if (memo[index][remaining] != null) return memo[index][remaining];

        boolean take = helper(nums, index + 1, remaining - nums[index], memo);
        boolean skip = helper(nums, index + 1, remaining, memo);
        return memo[index][remaining] = take || skip;
    }
}

// 

// 3. Tabulation — Bottom-Up DP

// dp[i][j] = "using the first i numbers, can we make sum exactly j?" Classic 0/1 knapsack table.


// Complexity: O(n · target) time, O(n · target) space.


class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // base case: sum 0 is always achievable (take nothing)
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // skip this number
                if (j >= num) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num]; // OR take this number
                }
            }
        }
        return dp[n][target];
    }
}


