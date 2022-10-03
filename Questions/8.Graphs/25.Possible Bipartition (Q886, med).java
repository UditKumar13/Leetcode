class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int []nodes : dislikes){
            int u = nodes[0]-1;
            int v = nodes[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // graph has been made 
        boolean ans = checkBipartite(n,adj);
        return ans;
    }
    
    
    boolean bfsCheck(ArrayList<ArrayList<Integer>>adj, int[] color, int node){
        Queue <Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        
        while(!q.isEmpty()){
            Integer nde = q.poll();
            for(Integer it : adj.get(nde)){
                if(color[it] == -1){
                    color[it] = 1 - color[nde];
                    q.add(it);
                }else if(color[it] == color[nde]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean checkBipartite(int n,ArrayList<ArrayList<Integer>> adj){
        int []color = new int[n+1];
        
        for(int i=0;i<n;i++){
            color[i] = -1;
        }
        
        for(int i=1;i<n;i++){
            if(color[i] == -1){
                if(bfsCheck(adj,color,i) == false){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}