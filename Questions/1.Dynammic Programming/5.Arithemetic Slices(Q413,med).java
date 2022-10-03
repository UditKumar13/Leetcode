class Solution {
    private int calSum(int []arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <=2) return 0;
        int len = nums.length;
        int []dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=len-1;i++){
            int gap1 = nums[i] - nums[i-1];
            int gap2 = nums[i-1] - nums[i-2];
            if(gap1 == gap2){
                dp[i] = dp[i-1] + 1;
            }
            else dp[i] = 0;
        }
        for(int a: dp){
            System.out.print(a + " ");
        }
        int sum = calSum(dp);
        return sum;
    }
}