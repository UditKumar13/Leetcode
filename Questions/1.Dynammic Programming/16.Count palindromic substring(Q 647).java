class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean [][] dp = new boolean [len][len];
        int count = 0;
        for(int g=0;g<len;g++){
            for(int i=0, j =g; j<dp.length;i++,j++){
                
                if(g == 0){
                    dp[i][j] = true ;
                }
                
                else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    else dp [i][j] = false ; 
                }
                
                else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                    
                    else dp[i][j] = false;
                }
                
                // condition to check 
                if(dp[i][j]) count++;
            }
        }
        
        return count;
    }
} 