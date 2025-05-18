// TC : O(N*N*4) 
// at the worst case suppose we have all rotten oranges that can be N*N , and for every cell we are exploring the 4 directions so that's why the time complexity is that 

// SC : O(N*N)
// queue stack can be N*N in the worst case where every cell in the matrix is a rotten  orange

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length,n = grid[0].length;
        Queue <int[]> q = new LinkedList<>();
        int count_all_non_empty_cells_initially =0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    // rotten 
                    q.offer(new int[]{i,j});
                }
                
                if(grid[i][j] != 0 ){
                    count_all_non_empty_cells_initially++;
                }
            }
        }
        
        // for loop ends here 
        int min_Time =  0,non_empty_cells_with_bfs= 0;
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};
        
        // main logic bfs 
        while(!q.isEmpty()){
            int size = q.size();
            non_empty_cells_with_bfs += size; // count the number of ele in queue
            for(int i=0;i<size;i++){
                int [] point = q.poll();
                for(int j=0;j<4;j++){
                    int row = point[0] + dx[j];
                    int col = point[1] + dy[j];
                    
                    if(row <0 || col <0 || row >=m || col >= n ||grid[row][col] == 0 || grid[row][col] == 2) continue;
                    
                    grid[row][col] = 2; // make this 1 as 2 rotten orange 
                    q.offer(new int[]{row,col});
                    
                }
            }
            
            if(!q.isEmpty()){
                // this mean 1 iteration has been completed 
                min_Time++; 
            }
        }
        
        // while closes here
        return count_all_non_empty_cells_initially == non_empty_cells_with_bfs ? min_Time: -1;
         
    }
}
