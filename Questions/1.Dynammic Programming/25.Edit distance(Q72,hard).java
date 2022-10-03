
// Approach 1 : 

class Solution {
    
    public int f(int i,int j,String s1, String s2){
        
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s1.charAt(i) == s2.charAt(j)) return f(i-1,j-1,s1,s2);
        int replace = 1 + f(i-1,j-1,s1,s2);
        int delete = 1 + f(i-1,j,s1,s2);
        int insert = 1 + f(i,j-1,s1,s2);
        
        int c1 = Math.min(replace,delete);
        
        c1 = Math.min(c1,insert);
        return c1;
    }
    
    
    public int minDistance(String word1, String word2) {
        
        int n = word1.length(), m = word2.length();
        return f(n-1,m-1,word1,word2);
    }
}

// TC : O(2 *n*m)


exponential 


// Approach 2 :

class Solution {
    
    public int f(int i,int j,String s1, String s2,int[][] dp){
        
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = f(i-1,j-1,s1,s2,dp);
        int replace = 1 + f(i-1,j-1,s1,s2,dp);
        int delete = 1 + f(i-1,j,s1,s2,dp);
        int insert = 1 + f(i,j-1,s1,s2,dp);
        
        int c1 = Math.min(replace,delete);
        
        c1 = Math.min(c1,insert);
        return dp[i][j] = c1;
    }
    
    
    public int minDistance(String word1, String word2) {
        
        int n = word1.length(), m = word2.length();
        
        int [][]dp = new int[n][m];
        
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }
        
        
        return f(n-1,m-1,word1,word2,dp);
    }
    
    
}


// TC  :O(n * m)

// SC : O(n*m)


// Approach  3 : Tabulation 

class Solution {
    

 
    public int minDistance(String word1, String word2) {
        
        int n = word1.length(), m = word2.length();
        
        int [][]dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) dp[i][0] = i;
        for(int j=0;j<=m;j++) dp[0][j] = j;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
                                            
       return dp[n][m];
      
        
    }
    
    
}

// tc : O(n*m)

// sc :O(n*m)



