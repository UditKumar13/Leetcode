class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m =  maze.length, n = maze[0].length;
        Queue <int[]> q = new LinkedList<>();
        boolean [][]vis = new boolean [m][n];
        q.add(new int[]{entrance[0],entrance[1]});
        int exitSteps = 0;
        vis[entrance[0]][entrance[1]] = true;
        int [][]dir = {{0,-1},{0,+1},{-1,0},{+1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            exitSteps++;
            
            for(int i=0;i<size;i++){
            int [] curr = q.poll();
            int new_x, new_y;
            
            
            if(maze[curr[0]][curr[1]] == '.'){
                 for(int[] d : dir){
                new_x = curr[0] + d[0];
                new_y = curr[1] + d[1];
                if(new_x <0 || new_y <0 || new_x >= maze.length || new_y >=maze[0].length) continue;
                if(vis[new_x][new_y] == true || maze[new_x][new_y] == '+') continue;
                if(new_x == 0 || new_y == 0 || new_x == m-1 || new_y == n-1) return exitSteps;
                vis[new_x][new_y] = true;
                q.add(new int[]{new_x,new_y});
            }
            }
            }
           
           
        }
        return -1;
}
}