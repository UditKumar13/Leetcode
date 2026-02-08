class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        
        // Monotonic deques to track min and max indices
        Deque<Integer> minDeque = new ArrayDeque<>();  // increasing values
        Deque<Integer> maxDeque = new ArrayDeque<>();  // decreasing values
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // Add current element to deques
            
            // Maintain minDeque (increasing order)
            while (!minDeque.isEmpty() && 
                   nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // Maintain maxDeque (decreasing order)
            while (!maxDeque.isEmpty() && 
                   nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Shrink window while cost > k
            while (left <= right) {
                int min = nums[minDeque.peekFirst()];
                int max = nums[maxDeque.peekFirst()];
                long length = right - left + 1;
                long cost = (long)(max - min) * length;
                
                if (cost <= k) {
                    break;  // Window is valid
                }
                
                // Remove left element from deques
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                
                left++;
            }
            
            // All subarrays ending at 'right' starting from 'left' are valid
            count += (right - left + 1);
        }
        
        return count;
    }
}