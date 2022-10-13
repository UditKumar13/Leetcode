class Solution {
    int mod = 1000000007;
    int [][][]dp;
    public int numberOfPaths(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        dp = new int[r][c][k];
        for(int [][]a : dp){
            for(int []b :a){
                Arrays.fill(b,-1);
            }
        }
        
        return helper(grid,0,0,0,k);
    }
    
    public int helper(int [][]grid, int r, int c,int sum,int k){
        if(r<0 || r== grid.length || c <0 || c== grid[0].length){
            return 0;
        }
        
        sum += grid[r][c];
        if(r == grid.length -1 && c == grid[0].length-1){
            return sum%k == 0 ? 1: 0; 
        }
        
        if(dp[r][c][sum % k] != -1){
            return dp[r][c][sum % k];
        }
        
        dp[r][c][sum % k] = ((helper(grid,r+1,c,sum,k) + helper(grid,r,c+1,sum,k))) % mod;
        return dp[r][c][sum % k];
        
        
    }
    
    
    
  
        
}