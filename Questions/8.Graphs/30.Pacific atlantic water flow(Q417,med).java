class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int [][] pac = new int[m][n];
        int [][] alt = new int[m][n];
        for(int[] row: pac) Arrays.fill(row,-1);
        for(int[] row: alt) Arrays.fill(row,-1);
        for(int i=0,j=0;j<n;j++) pac[i][j] = 1;
        for(int i=0,j=0;i<m;i++) pac[i][j] = 1;
        for(int i=m-1,j=0;j<n;j++) alt[i][j] = 1;
        for(int i=0,j=n-1;i<m;i++) alt[i][j] = 1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] == 1){
                    bfs(heights,pac,i,j);
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(alt[i][j] == 1){
                    bfs(heights,alt,i,j);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                List<Integer> curr = new ArrayList<>();
                if(pac[i][j] == 1 && alt[i][j] == 1) {
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
                
            }
        }
        
        
        
      return ans;  
        
    }
    
    
    public void bfs(int [][]hills, int[][] vis, int row, int col){
        Queue<int[]>q = new LinkedList<>();
        int m = hills.length, n = hills[0].length;
        q.add(new int[]{row,col});
        int size;
        int [][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            size = q.size();
            int []curr = q.poll();
            int new_x, new_y;
            for(int i=0;i<size;i++){
                
                for(int[] d: dir){
                    new_x = curr[0] + d[0];
                    new_y = curr[1] + d[1];
                    if(new_x <0 || new_y <0 || new_x >=m || new_y >=n){
                        continue;
                    }
                    if(vis[new_x][new_y] == 1){
                        continue;
                    }
                    if(hills[new_x][new_y] >= hills[curr[0]][curr[1]]){
                        // valid move
                        vis[new_x][new_y]  = 1;
                        q.add(new int[]{new_x,new_y});
                    }
                }
            }
        }
    }
}


// tc : O(n*m)

// sc : O(n*m)