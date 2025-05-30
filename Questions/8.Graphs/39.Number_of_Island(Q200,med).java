class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int [][]visited = new int[row][col];
        
        int numIsland =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                numIsland++;
                dfs(grid,visited,i,j);    
                }
                
            }
        }
        return numIsland;
    }
    
    
    public void dfs(char[][]grid, int[][] visited, int row, int col){
        if(row <0 || col <0 || row >=grid.length || col >= grid[0].length || grid[row][col] == '0' || visited[row][col] == 1){
            return;
        }
        char ch = grid[row][col];
        if(ch == '1'){
            visited[row][col] = 1;
            int []dx = {0,0,-1,+1};
            int []dy = {-1,+1,0,0};
            for(int k=0;k<4;k++){
                int new_row = row + dx[k];
                int new_col = col + dy[k];
                dfs(grid,visited,new_row,new_col);
            }
        }
    }
}