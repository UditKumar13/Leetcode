class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = "";
        for(int i =s.length()-1;i>=0;i--){
            rev += s.charAt(i);
        }
        
        // we will use the lcs 
        int lps = LCS(s,rev);
        return lps;
    }
    
    public int LCS(String s, String t){
        int  m = s.length(), n = t.length();
        int [][] dp = new int [m+1][n+1];
        
        for(int i=dp.length-2; i>=0 ;i--){
            for(int j = dp[0].length-2; j>=0 ; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]  + 1;
                }
                
                else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}