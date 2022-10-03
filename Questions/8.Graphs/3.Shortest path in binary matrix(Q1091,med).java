TC O(m*n), SC O(m*n)

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1) return -1;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0,1}); // row col nodes 
        grid[0][0] = 1;
   
        int [][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int []point = q.poll();
                if(point[0] == m-1 && point[1] == n-1) return point[2];
                
                for(int []d : dir){
                    int row = point[0] + d[0];
                    int col = point[1] + d[1];
                    if(row >=0 && col >=0 && row <m && col <n && grid[row][col] == 0){
                        q.add(new int[]{row,col,point[2]+1});
                        grid[row][col] = 1;
                    }
                 }
            }
        }
        return -1;
    }
}