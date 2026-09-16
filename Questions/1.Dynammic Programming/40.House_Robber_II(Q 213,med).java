class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(
            robLine(nums, 0, n - 2),
            robLine(nums, 1, n - 1)
        );
    }
    // same recursive logic as House Robber I, but bounded to [start, end]
    private int robLine(int[] nums, int start, int end) {
        return helper(nums, end, start);
    }
    private int helper(int[] nums, int i, int start) {
        if (i < start) return 0;
        if (i == start) return nums[i];
        return Math.max(helper(nums, i - 1, start), nums[i] + helper(nums, i - 2, start));
    }
}

// Brute Force (Recursion, no memo) — O(2ⁿ) time

/*

func rob(nums []int) int {
    n := len(nums)
    if n == 1 {
        return nums[0]
    }
    a := robLine(nums, 0, n-2)
    b := robLine(nums, 1, n-1)
    if a > b {
        return a
    }
    return b
}
func robLine(nums []int, start, end int) int {
    return helper(nums, end, start)
}
func helper(nums []int, i, start int) int {
    if i < start {
        return 0
    }
    if i == start {
        return nums[i]
    }
    skip := helper(nums, i-1, start)
    take := nums[i] + helper(nums, i-2, start)
    if skip > take {
        return skip
    }
    return take
}
*/

/ top down approach 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(
            robLine(nums, 0, n - 2),
            robLine(nums, 1, n - 1)
        );
    }
    // same recursive logic as House Robber I, but bounded to [start, end]
    private int robLine(int[] nums, int start, int end) {
        return helper(nums, end, start);
    }
    private int helper(int[] nums, int i, int start) {
        if (i < start) return 0;
        if (i == start) return nums[i];
        return Math.max(helper(nums, i - 1, start), nums[i] + helper(nums, i - 2, start));
    }
}

// Time: O(n) | Space: O(n) (for the recursion stack and memoization array)

// optimal bottom up approach
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(
            robLine(nums, 0, n - 2),
            robLine(nums, 1, n - 1)
        );
    }
    private int robLine(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Time: O(n) | Space: O(1)

