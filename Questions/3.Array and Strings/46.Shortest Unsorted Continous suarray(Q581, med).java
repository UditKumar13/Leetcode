
SC // O(1)
TC // O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int size = nums.length;
        int low = 0, high = size-1;
        while (low+1<size && nums[low] <= nums[low+1]) low++;
        while(high-1>=0 && nums[high-1] <= nums[high]) high--;
        if(low == size-1 && high == 0) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int m=low, n = high;
        while(m<=high){
            if(nums[m] < min) min = nums[m];
            if(nums[m] > max) max = nums[m];
            m++;
        }
        int count = high-low+1;
        for(int i=low-1;i>=0;i--){
            if(nums[i] > min) count++;
        }// checkking the left 
        
        for(int i=high+1;i<size;i++){
            if(nums[i] < max) count++;
        }
        return count;
        
    }
}