class Solution {
    private static Integer  WHITE = 0;
    private static Integer  GREY = 1;
    private static Integer  BLACK = 2;
        
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        Map <Integer,Integer> nodesState = new HashMap<>();
        int len = graph.length;
        for(int i=0;i<len;i++){
            nodesState.put(i,WHITE);
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(dfs(graph,i,nodesState)){
                output.add(i);
            }
        }
        
        
        return output;
        
    }
    
    
    public boolean dfs(int[][] graph, int node,Map<Integer,Integer>nodesState){
        if(nodesState.get(node) == GREY){
            return false;
        }
        
        if(nodesState.get(node) == BLACK){
            return true;
        }
        
        nodesState.put(node,GREY);
        
        for(int neigbour : graph[node]){
            if(nodesState.get(neigbour) == WHITE){
                boolean pathExist = dfs(graph,neigbour,nodesState);
                if(pathExist == false) return false;
                
            }
            
            else if(nodesState.get(neigbour) == GREY) return false;
        }
        
        nodesState.put(node,BLACK);
        // hum post order mein hi black krenge that means it is a good node 
        return true;
    }
}

// https://www.youtube.com/watch?v=yFJpECT0GvU&t=1012s
// TC : O(n+e)

