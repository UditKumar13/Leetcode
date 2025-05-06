//Using Dijkstra's algortihm 
// TC : O((n+e)logn) actually it was (e.log n ^ 2)

class Solution {
    
    
    public int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minID = -1;
        for(int i=0;i<distance.length;i++){
            if(!visited[i] && distance[i] < min){
                minID = i;
                min = distance[i];
            }
        }
        return minID;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int [][] graph = new int [n][n];
        for(int i=0;i<n;i++) Arrays.fill(graph[i],Integer.MAX_VALUE);
        // graph is made now we have to fill the enteries 
        for(int [] rows : times) graph[rows[0]-1][rows[1]-1] = rows[2]; // becasue it is a 2d array 
        
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k-1] = 0; // source node

        // distance[i] array stores min distance to reach the node i from source node k.
        // graph [i][j] is the edge weight from i to j.
        // graph[i][j] = Integer.MAX_VALUE means no edge is present between i and j.

        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++){
            int v = minIndex(distance,visited);
            // it helps us to find the next minimum distance node which is not visited yet from the previous source.
            if(v == -1) continue;
            visited[v] = true;
            for(int j=0; j<n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    // some neighbour is present 
                    int newdist = distance[v] + graph[v][j];
                    if (newdist < distance[j]) distance[j] = newdist;
                    
                }
            }
        }
        
        int result = 0;
        for(int dist :  distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result=Math.max(result,dist);
        }
        
        return result;
        
        
    }
}