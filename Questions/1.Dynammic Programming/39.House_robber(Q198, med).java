class Solution {
    public int rob(int[] nums) {
        return helper(nums, nums.length-1);
    }

    public int helper(int[] nums, int i){
        if (i < 0) return 0;
        if (i == 0) return nums[0];

        return Math.max(helper(nums, i-1), nums[i] + helper(nums, i-2));
    }
}

// Time: O(2^n) | Space: O(n) (for the recursion stack)

/*
func rob(nums []int) int {
    return helper(nums, len(nums)-1)
}

func helper(nums []int, i int) int {
    if i < 0 {
        return 0;
    }
    if i == 0 {
        return nums[0]
    }
    skip := helper(nums, i-1)
    take := nums[i] + helper(nums, i-2)

    if skip > take {
        return skip
    }
    return take
}
*/

// better solution using dp : top down approach

class Solution {
    private int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length-1);
    }

    public int helper(int[]nums, int i){
        if (i<0) return 0;
        if (i == 0) return nums[0];

        if (dp[i] != -1) return dp[i];

        int skip = helper(nums, i-1);
        int take = nums[i] + helper(nums, i-2);

        dp[i] = Math.max(skip, take);
        return dp[i];
    }
}

// Time: O(n) | Space: O(n) (for the dp array + recursion stack)

/*
func rob(nums []int) int {
    dp := make([]int, len(nums))
    for i:= range dp{
        dp[i] = -1
    }
    return helper(nums, len(nums)-1, dp)
}

func helper(nums []int, i int, dp []int) int {
    if i < 0 {
        return 0;
    }
    if i == 0 {
        return nums[0]
    }
    if dp[i] != -1 {
        return dp[i]
    }

    skip := helper(nums, i-1, dp)
    take := nums[i] + helper(nums, i-2, dp)

    if skip > take {
        dp[i] = skip
    }else {
        dp[i] = take
    }
    
    return dp[i]
}
*/

class Solution {
    public int rob(int[] nums) {
        int prev2 = 0; // best loot up to i-2
        int prev1 = 0; // best loot up to i-1
        for (int num : nums) {
            int curr = Math.max(prev1, num + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Time: O(n) | Space: O(1)
