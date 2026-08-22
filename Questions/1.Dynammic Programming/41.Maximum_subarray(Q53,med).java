class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }
}

// Time: O(n^2) | Space: O(1)

// top down appraoch using dp

class Solution {
    private int[] memo;
    private int best;
    
    public int maxSubArray(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            best = Math.max(best, helper(nums, i));
        }
        return best;
    }
    private int helper(int[] nums, int i) {
        if (i == 0) return nums[0];
        if (memo[i] != Integer.MIN_VALUE) return memo[i];
        memo[i] = Math.max(nums[i], helper(nums, i - 1) + nums[i]);
        return memo[i];
    }
}

// Time: O(n) | Space: O(n) (for the memoization array)


// optimal solution using kadane's algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            best = Math.max(best, currSum);
        }
        return best;
    }
}

// Time: O(n) | Space: O(1)

