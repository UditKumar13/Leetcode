
// memoization approach
class Solution {
    
    // tc : O(m*n)
    // sc : O(m+n) + O(m*n) == O(m*n)
    // memo technique 
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = recursion(m-1, n-1, dp);
        return ans;
    }
    
    public int recursion(int i, int j, int[][]dp){
        if(i<0 || j<0) return 0;
        if(i == 0 && j ==0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int up = recursion(i-1, j, dp);
        int left = recursion(i, j-1,dp);
        return dp[i][j] = up + left;
    }
}

// tabulation approach 
class Solution {
    
    // tc : O(m*n)
    // sc : O(m*n)
    //tabulation 
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                int up = 0, left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up + left;  
                }
               
            }
        }
        
        return dp[m-1][n-1];
    }
}

