class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int row = matrix.length, col = matrix[0].length;
        
        int [][] dp = new int[row][col];
        
        for(int i=0;i<col;i++){
            dp[0][i] = matrix[0][i]; 
        }
        
        // base case 
        int minSum = Integer.MAX_VALUE;
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                
                if(j == 0){
                    dp[i][j]  = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }
                
                else if(j == col-1){
                     dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }
                
                else {
                    int comp = Math.min(dp[i-1][j-1],dp[i-1][j+1]);
                    dp[i][j] = Math.min(dp[i-1][j],comp) + matrix[i][j];
                }
            }
        }
        
        
        for(int i=row-1,j=0;j<col;j++){
            minSum = Math.min(minSum,dp[i][j]);
        }
        
        return minSum;
    }
}


// TC : O(n * m )

// SC : O(n *m )

