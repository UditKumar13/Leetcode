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
// Why this is equivalent to "no cycle"

// This is really just simulating a valid course order one layer at a time (like BFS levels). 
// If you can peel off all V nodes this way, you've produced a valid topological order — which only
//  exists for a DAG. If you get stuck with leftover nodes whose indegree never reaches 0, those 
//  leftover nodes must form (or feed into) a cycle, since the only reason a 
// node's indegree stays positive forever is that its prerequisite chain loops back to itself.

// bfs 

TC : O(n + e)

SC : O(n+e) + O(n)


// dfs 

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            // p[0] depends on p[1] -> edge p[1] -> p[0]
            graph.get(p[1]).add(p[0]);
        }

        // 0 = unvisited, 1 = visiting (in current DFS path), 2 = fully processed
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return false; // back edge -> cycle found
        if (state[node] == 2) return true;  // already verified, skip

        state[node] = 1; // mark as "in progress"
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }
        state[node] = 2; // mark as fully processed
        return true;
    }
}