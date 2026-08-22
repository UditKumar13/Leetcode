// Longest Increasing Subsequence (LC 300): given an array, find the length of the longest strictly
//  increasing subsequence (elements don't need to be contiguous, just in order).

// Recurrence: define dp[i] = length of the longest increasing subsequence ending exactly at index i.
//  For each i, look back at every j < i — if nums[j] < nums[i], you could extend that subsequence:

// dp[i] = 1 + max(dp[j]) for all j < i where nums[j] < nums[i] (or just 1 if no such j exists — the 
// element alone).

// Answer = max(dp[0..n-1]) (best subsequence could end anywhere, same as Maximum Subarray).

class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1); // -1 = no previous element chosen yet
    }
    // i = current index, prevIndex = index of last chosen element (-1 if none)
    private int helper(int[] nums, int i, int prevIndex) {
        if (i == nums.length) return 0;
        
        int skip = helper(nums, i + 1, prevIndex); // don't take nums[i]
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + helper(nums, i + 1, i); // take nums[i], it becomes new prev
        }
        return Math.max(skip, take);
    }
}

// Brute Force (Recursion, no memo) — O(2ⁿ) time

/*

func lengthOfLIS(nums []int) int {
    return helper(nums, 0, -1)
}
func helper(nums []int, i, prevIndex int) int {
    if i == len(nums) {
        return 0
    }
    skip := helper(nums, i+1, prevIndex)
    take := 0
    if prevIndex == -1 || nums[i] > nums[prevIndex] {
        take = 1 + helper(nums, i+1, i)
    }
    if skip > take {
        return skip
    }
    return take
}

*/

// top down approach using dp (memoization)

// Note the state shape: it's a pair (i, prevIndex), similar to Coin Change II's (i, amount).
//  This is your cue that memoization needs 2 dimensions.

// Top-Down (Memoization) — O(n²) time, O(n²) space

class Solution {
    private Integer[][] memo;
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n + 1]; // prevIndex shifted by +1 to allow -1 as index 0
        return helper(nums, 0, -1);
    }
    private int helper(int[] nums, int i, int prevIndex) {
        if (i == nums.length) return 0;
        if (memo[i][prevIndex + 1] != null) return memo[i][prevIndex + 1];
        
        int skip = helper(nums, i + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + helper(nums, i + 1, i);
        }
        memo[i][prevIndex + 1] = Math.max(skip, take);
        return memo[i][prevIndex + 1];
    }
}

/*
in go : 
func lengthOfLIS(nums []int) int {
    n := len(nums)
    memo := make([][]int, n)
    for i := range memo {
        memo[i] = make([]int, n+1)
        for j := range memo[i] {
            memo[i][j] = -1 // -1 = "not computed"
        }
    }
    return helper(nums, 0, -1, memo)
}
func helper(nums []int, i, prevIndex int, memo [][]int) int {
    if i == len(nums) {
        return 0
    }
    if memo[i][prevIndex+1] != -1 {
        return memo[i][prevIndex+1]
    }
    skip := helper(nums, i+1, prevIndex, memo)
    take := 0
    if prevIndex == -1 || nums[i] > nums[prevIndex] {
        take = 1 + helper(nums, i+1, i, memo)
    }
    result := skip
    if take > result {
        result = take
    }
    memo[i][prevIndex+1] = result
    return result
}
*/

// Bottom-Up (Standard O(n²) DP) — the version to actually say out loud in an interview

// This uses the simpler, more common formulation: dp[i] = LIS length ending at i.


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // every element alone is a subsequence of length 1
        
        int best = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}

// Bottom-Up (Standard O(n²) DP) — the version to actually say out loud in an interview

/*
in go : 
func lengthOfLIS(nums []int) int {
    n := len(nums)
    dp := make([]int, n)
    for i := range dp {
        dp[i] = 1
    }
    best := 1
    for i := 1; i < n; i++ {
        for j := 0; j < i; j++ {
            if nums[j] < nums[i] && dp[j]+1 > dp[i] {
                dp[i] = dp[j] + 1
            }
        }
        if dp[i] > best {
            best = dp[i]
        }
    }
    return best
}
*/

// most optimal 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0; // current length of the "tails" array
        
        for (int num : nums) {
            int lo = 0, hi = size;
            while (lo < hi) { // binary search: find first index where tails[idx] >= num
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = num;
            if (lo == size) size++; // num extended the sequence
        }
        return size;
    }
}

// Optimal (Binary Search + Patience Sorting) — O(n log n) time

// This is a genuinely different technique, not just an optimization of the DP above — 
// worth treating as its own thing.

// Idea: maintain an array tails, where tails[k] = the smallest possible tail value of an
//  increasing subsequence of length k+1. For each new number, binary search for where it fits:

// If it's bigger than everything in tails, append it (extends the LIS).
// Otherwise, replace the first element in tails that is ≥ the current number (keeps tails as
//  small as possible, maximizing future extension potential).