class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}

// brute force approach : O(n*k) | O(1) (constant space for max variable)

/*
brute force in go : 
func maxSlidingWindow(nums []int, k int) []int {
    n := len(nums)
    result := make([]int, n-k+1)

    for i := 0; i+k <= n; i++ {
        max := math.MinInt32
        for j := i; j < i+k; j++ {
            if nums[j] > max {
                max = nums[j]
            }
        }
        result[i] = max
    }
    return result
}
*/


// optimal solution 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices, values decreasing

        for (int right = 0; right < n; right++) {
            // maintain decreasing order: pop smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);

            // remove front if it's out of the window
            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // record result once we have a full window
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}

// optimal approach : O(n) | O(k) (deque of size k)

