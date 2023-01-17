class Solution {
    public int minFlipsMonoIncr(String s) {
        int []dp = new int[2];
        
        for(int i=0;i<s.length();i++){
            int temp = dp[0] + (s.charAt(i) == '1' ? 1:0 ) ;
            dp[1] = Math.min(dp[0],dp[1]) + (s.charAt(i) == '0' ? 1:0 ) ;
            dp[0] = temp;
        }
        
        return Math.min(dp[0],dp[1]);
    }
}

https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/3061815/Clean-Codesoror-Dynamic-Programming-oror-C%2B%2Boror-Java-oror-Python3

python 3  :
https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/3061225/Python-3-oror-7-lines-w-explanation-and-example-oror-TM%3A-100-96

