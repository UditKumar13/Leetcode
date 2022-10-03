class Solution {
    public int findMaxSubarraySum(int[] nums){
        int sum = nums[0];
        int max = nums[0];
        int len = nums.length;
        for(int i=1; i<len;i++){
            if (sum <0) sum =0;
            sum += nums[i];
            
            max =Math.max(sum,max);
        }
        return max;
    }
    
    public int findMinSubarraySum(int[] nums){
        int sum = nums[0];
        int min = nums[0];
        int len = nums.length;
        
        for(int i=1;i<len;i++){
            if (sum > 0) sum =0;
            sum  += nums[i];
            
            min = Math.min(sum,min);
        }
        return min;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int max = findMaxSubarraySum(nums);
        System.out.println(max);
        int min = findMinSubarraySum(nums);
        System.out.println("minimun : " + min);
        int rival = max;
        int sum =0;
        for(int num: nums){
            sum += num;
        }

        
        rival = sum - min;
        if (rival == 0) return max ;
        return rival > max ? rival : max;
        
    }
}