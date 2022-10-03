class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int [m+1][n+1];
        
        
        for(String s : strs){
            int []count = count(s);
            for(int zero =m;zero>=count[0];zero--){
                for(int one =n;one>= count[1];one--){
                    dp[zero][one] = Math.max(dp[zero - count[0]][one - count[1]] + 1, dp[zero][one]);
                }
            }
        
        }
        return dp[m][n];
    }
    
    public int[] count(String s){
        int [] count = new int[2];
        for(char ch : s.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}