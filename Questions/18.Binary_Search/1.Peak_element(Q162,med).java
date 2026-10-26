class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean leftOk = (i == 0) || nums[i] > nums[i - 1];
            boolean rightOk = (i == n - 1) || nums[i] > nums[i + 1];
            if (leftOk && rightOk) return i;
        }
        return -1; // unreachable given problem constraints
    }
}

// tc : O(n), sc: O(1)

/*
func findPeakElement(nums []int) int {
    n := len(nums)
    for i := 0; i < n; i++ {
        leftOk := i == 0 || nums[i] > nums[i-1]
        rightOk := i == n-1 || nums[i] > nums[i+1]
        if leftOk && rightOk {
            return i
        }
    }
    return -1 // unreachable
}
*/

// optimal 
// using binary search

/*
Optimal — Binary Search, O(log n)

Key insight: if nums[mid] < nums[mid+1], there must be a peak somewhere to the right (the sequence is "climbing"), so move lo = mid + 1. Otherwise, a peak exists at mid or to its left, so move hi = mid. This works because the array's boundaries are treated as -∞, guaranteeing a peak always exists in whichever half you keep.
*/


