class Solution {
    public boolean canFinish(int V, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
       
          for(int i=0; i<V; i++){
            adj.add(i,new ArrayList<>());
        }
        int [] indegree = new int [V];
        for(int []e : pre){
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }
        
        // we will use the topological sort for estimating the answer
        int [] topo = new int [V];
        Queue <Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        
        // Queue done
        
        int cnt = 0;
        
        while(! q.isEmpty()){
            Integer node = q.poll();
            cnt++;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        boolean canFinish = false;
        if(cnt == V) {
// that means topological sort is possible so it is possible for DAG
// that means no cycle found, so course schedule is possible. 
            return true;
        }
        
        return canFinish;
    }
}


// bfs 

TC : O(n + e)

SC : O(n+e) + O(n)