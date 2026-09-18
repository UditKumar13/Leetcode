class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    private int helper(int[] nums, int index, int remaining) {
        if (index == nums.length) {
            return remaining == 0 ? 1 : 0; // used all numbers, check if we hit target
        }

        int plus  = helper(nums, index + 1, remaining - nums[index]); // assign +
        int minus = helper(nums, index + 1, remaining + nums[index]); // assign -
        return plus + minus;
    }
}

// 1. Brute Force — Recursion

// Try + and - for each number, count paths that land exactly on S after using all numbers.

// Complexity: O(2ⁿ) time — each number branches into +/-, O(n) recursion depth.

// Why it's slow: helper(index, remaining) recomputed many times for the same (index, remaining)
//  pair reached via different sign combinations — overlapping subproblems.


// 

// 2. Memoization — Top-Down DP

// remaining can go negative here (unlike Partition Equal Subset Sum), so use a 
// HashMap<String, Integer> or offset the range into an array.

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, 0, target, memo);
    }

    private int helper(int[] nums, int index, int remaining, Map<String, Integer> memo) {
        if (index == nums.length) {
            return remaining == 0 ? 1 : 0;
        }

        String key = index + "," + remaining;
        if (memo.containsKey(key)) return memo.get(key);

        int plus  = helper(nums, index + 1, remaining - nums[index], memo);
        int minus = helper(nums, index + 1, remaining + nums[index], memo);
        int result = plus + minus;

        memo.put(key, result);
        return result;
    }
}


// Complexity: O(n · range) time where range is the number of distinct remaining values
//  encountered (bounded by 2 · sum(nums) + 1), same for space, plus O(n) recursion stack.

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int total = 0;
        for (int num : nums) total += num;

        // sum(P) must be a non-negative integer within [0, total]
        if (S > total || S < -total || (S + total) % 2 != 0) return 0;

        int target = (S + total) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1; // base case: 0 numbers used, only way to reach sum 0 is "do nothing"

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // don't put num in P (i.e. num gets a '-')
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num]; // put num in P (i.e. num gets a '+')
                }
            }
        }
        return dp[n][target];
    }
}

// Complexity: O(n · target) time, O(n · target) space.

// Note the += instead of || — this is the counting variant (add up the number of ways from both choices)
//  rather than the existence variant (OR them together) from Partition Equal Subset Sum. Same table shape,
//   different combining operator — same pattern shift you saw between Unique Paths (sum) and Min Path Sum (min).