// Approach 1 :


class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i,new ArrayList<>());
        }
        int [] deg = new int[n];
        for(int []nodes: roads){
            int u = nodes[0];
            int v = nodes[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }
        
        int maxNet = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1;j<n;j++){
                int temp = deg[i] + deg[j];
                if(adj.get(i).contains(j)) temp--;
                
                maxNet = Math.max(maxNet,temp);
            }
        }
        
        return maxNet;
        
        
    }
}

// TC  : O(n*2)