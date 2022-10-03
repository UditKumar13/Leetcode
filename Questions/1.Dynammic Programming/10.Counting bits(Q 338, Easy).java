class Solution {
    public int[] countBits(int n) {
        int  [] dp = new int [n+1];

        
         dp[0] = 0;
        if (n == 0) return dp;
         dp[1] = 1;
        if (n == 1) return dp; 
        for(int i=2;i<=n;i++){
            if(i%2 != 0) {
                int prevdiv2 = (i-1)/2;
                dp[i] = dp[prevdiv2] + 1;
            }
            else dp[i] = dp[i/2];
        }
        
        return dp;
        
        
    }
}