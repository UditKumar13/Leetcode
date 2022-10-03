class Solution {
    
    public boolean subsetSum(int sum, int[] arr){
        boolean [][] dp = new boolean [sum+1][arr.length+1];
        int n=arr.length;
        for(int i=0;i<=n;i++){
            dp[0][i] = true;
        }
        
        for(int j=1;j<=sum;j++){
            dp[j][0] = false;
        }
        
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                
                if(i >= arr[j-1]){
                    dp[i][j] = dp[i][j] || dp[i-arr[j-1]][j-1]; 
                }
            }
        }
        return dp[sum][n];
        
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        int target = sum >> 1;
        if (sum % 2 == 0)  return subsetSum(target,nums);
            
        else return false;
        
       
        
    }
}