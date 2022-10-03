class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int row = grid.length, col = grid[0].length;
        int []maxGold = new int[1];
        maxGold[0] = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] !=0){
                    dfs(grid,i,j,0,maxGold);
                }
            }
        }
        
        return maxGold[0];
    }
    
    
    public void dfs(int[][]grid,int row,int col,int curr, int[] maxGold){
        
       if(row <0 || col <0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
           maxGold[0] = Math.max(maxGold[0], curr);
           return;
       }
        
        int val = grid[row][col];
        grid[row][col] = 0; // visited
        
        dfs(grid,row+1,col,curr + val,maxGold);
        dfs(grid,row-1,col,curr + val,maxGold);
        dfs(grid,row,col + 1, curr + val,maxGold);
        dfs(grid,row, col -1,curr + val,maxGold);
        
        grid[row][col] = val;
    }
}