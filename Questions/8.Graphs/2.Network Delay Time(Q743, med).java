Using Dijkstra's algortihm 
TC // O((n+e)logn)

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
        
        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++){
            int v = minIndex(distance,visited);
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