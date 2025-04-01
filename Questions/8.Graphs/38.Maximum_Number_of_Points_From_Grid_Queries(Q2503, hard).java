class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
       int m = grid.length, n = grid[0].length;
       int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
       int[] result = new int[queries.length];
       int[][] indexedQueries = new int[queries.length][2];
       for(int i=0; i<queries.length; i++){
        indexedQueries[i][0] = queries[i];
        indexedQueries[i][1] = i;
       } 
       Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));
       PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
       boolean[][] visited = new boolean[m][n];
       pq.offer(new int[]{grid[0][0], 0, 0}); // we are taking min pq rather than simple que
       // for optimizing the next minimum grid val for maximum traversal for every query.
       visited[0][0] = true; 

       int points = 0;
       int lastProcessedValue = 0;

       for(int[] query: indexedQueries){
        int qVal = query[0], idx = query[1];
        while(!pq.isEmpty() && pq.peek()[0] < qVal){
            int[] cell = pq.poll();
            int cellValue = cell[0], r = cell[1], c = cell[2];
            points++;
            for(int[] dir: directions){
                int newRow = r + dir[0], newCol = c + dir[1];
                if(newRow >=0 && newRow < m && newCol >=0 && newCol < n && !visited[newRow][newCol]){
                    pq.offer(new int[]{grid[newRow][newCol], newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        result[idx] = points;
       }
       return result;
    }
}