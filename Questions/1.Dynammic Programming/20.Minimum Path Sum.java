class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        int[][] dp = new int[row][col];
        
        //tabulation method small problem is 
        
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i == row-1 && j== col-1){
                    dp[i][j] = grid[i][j];
                }
                
                else if(i == row-1){
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                }
                
                else if(j == col-1){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }
                
                
                else {
                    int down = dp[i+1][j];
                    int right = dp[i][j+1];
                    dp[i][j] = Math.min(down,right) + grid[i][j];
                }
            }
        }
        
        return dp[0][0];
    }
}

// TC : O(m*n)
// SC : O(m*n)
// small problem is at dp[m-1][n-1]

// direction is from top bottom corner to left top corner 

