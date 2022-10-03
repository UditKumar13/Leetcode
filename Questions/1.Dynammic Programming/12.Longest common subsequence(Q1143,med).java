class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length(), n = t2.length();
        int [][] dp = new int [m+1][n+1];
        
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                char ch1 = t1.charAt(i);
                char ch2 = t2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }
                
                else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}


Tc // O(n**2)

Sc // O(n**2)