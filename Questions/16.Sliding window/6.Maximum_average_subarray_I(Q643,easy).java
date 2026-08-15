

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) return  0.0;
        int left = 0;
        double windowSum = 0;
        double maxSum = Double.NEGATIVE_INFINITY;

        for (int right = 0; right < nums.length; right++){
            windowSum += nums[right];
            while (right - left + 1 >= k){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left];
                left++;
            }
        }

        return maxSum == Double.NEGATIVE_INFINITY ? 0.0: (double)maxSum/k;
    }
}

// tc : O(n)
// sc : O(1)

/*

same in go language


func findMaxAverage(nums []int, k int) float64 {
	if k > len(nums) {
		return 0.0
	}

	left := 0
	windowSum := 0.0
	maxSum := math.Inf(-1) // negative infinity, equivalent to Double.NEGATIVE_INFINITY

	for right := 0; right < len(nums); right++ {
		windowSum += float64(nums[right])
		for right-left+1 >= k {
			maxSum = math.Max(maxSum, windowSum)
			windowSum -= float64(nums[left])
			left++
		}
	}

	if maxSum == math.Inf(-1) {
		return 0.0
	}
	return maxSum / float64(k)
}
    
*/