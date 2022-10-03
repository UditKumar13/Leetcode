class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        
        
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int idx=0;idx<len;idx++){
            for(int prev = 0; prev <=idx-1; prev++){
                
                if(nums[prev] < nums[idx]){
                    dp[idx] = Math.max(dp[idx],dp[prev] + 1);
                }
              
            }
              
                if(max < dp[idx]) max = dp[idx];
        }
        
        return max;
    }
}


// TC (O(n**2))
// SC (O(n))
// Dp tabulation 

