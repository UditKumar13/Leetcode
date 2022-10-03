// Approach 1 : dp 

class Solution {
    public int[][] updateMatrix(int[][] mat) {
    
        int m = mat.length, n = mat[0].length;
        if(m == 0 || n==0) return mat;
        int range = m * n;
        int [][] dp = new int[m][n];
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] ==0){
                    dp[i][j] = mat[i][j];
                }
                else{
                    int upcell = i>0 ? dp[i-1][j] : range;
                    int leftcell = j>0 ? dp[i][j-1] : range;
                    dp[i][j] = Math.min(upcell,leftcell) + 1;
                }
            }
        }
        
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                }
                
                else{
                    int rightcell = j<n-1 ? dp[i][j+1] : range ;
                    int downcell = i<m-1 ? dp[i+1][j] : range;
                    dp[i][j] = Math.min(Math.min(rightcell,downcell) + 1,dp[i][j]);
                }
            }
        }
        
        return dp;
    }
}



// TC : O(n**2)

// SC : O(n**2)


// Approach 2 :

BFS

class Solution {
    public int[][] updateMatrix(int[][] mat) {
    
        int m = mat.length, n = mat[0].length;
        if(m == 0 || n==0) return mat;
        
        // solving using bfs 
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else
                mat[i][j] = -1;
            }
        }
        
        int [] dirx = {0,0,-1,+1};
        int [] diry = {-1,+1,0,0};
        while(!q.isEmpty()){
            int [] curr_cell = q.poll();
            
            for(int i=0;i<4;i++){
                int nr = curr_cell[0] + dirx[i];
                int ny = curr_cell[1] + diry[i];
                
                if(nr<0 || ny <0 || nr >=m || ny >= n || mat[nr][ny] != -1) continue;
                
                mat[nr][ny] = mat[curr_cell[0]][curr_cell[1]] + 1;
                q.add(new int[]{nr,ny});
                
            }
            
        }
        
        
    return mat;
}
    
}



// TC : O(n**2)

// SC : O(n**2)





