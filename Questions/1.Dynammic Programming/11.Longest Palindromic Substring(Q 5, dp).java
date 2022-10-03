public String longestPalindrome(String s) {
  int n = s.length();
  String res = null;
    
  boolean[][] dp = new boolean[n][n];
    
  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
        res = s.substring(i, j + 1);
      }
    }
  }
    
  return res;
}


// not a good method 


// method 2 :
Gap method 

class Solution {
    public String longestPalindrome(String s) {
             int n = s.length();
        boolean [][] dp = new boolean [n][n];
        //gap method 
        int maxLen = 0;
        int fx = 0, fy = 0;
        for(int g =0; g<n;g++){
            for(int i=0, j = g; j<n; i++,j++){ 
                if(g==0){
                    dp[i][j] = true;
                 }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    else {dp[i][j] = false;}
                }else {
                    // gap 2
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                        }
                    else {
                        dp[i][j] = false;
                    }
                    
                }
                if(dp[i][j] == true) {
                    maxLen = g+1; 
                    fx = i;
                    fy = j+1;
                }
            }
        }
        return s.substring(fx,fy);
    } 
}


//