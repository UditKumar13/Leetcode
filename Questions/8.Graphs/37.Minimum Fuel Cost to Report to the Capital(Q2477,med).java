class Solution {
    long ans = 0;int s = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
       List<List<Integer>> graph = new ArrayList<>();
        s = seats;
        for(int i=0;i<=roads.length;i++){
            graph.add(new ArrayList());
        }
        for(int []r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        // making the list of the connected childs 
        
        dfs(0,0,graph);
        return ans;
    }
    
    public int dfs(int curr_node, int prev_node, List<List<Integer>> graph){
        int people = 1;
        for(int child : graph.get(curr_node)){
            if(child == prev_node) continue; // acting like  a visited, no need to write visited 
            people += dfs(child,curr_node,graph); // calculating the people 
        }
        if(curr_node != 0) ans += (people + s - 1)/s; // ceil value of the number of cars wrt to seats of single car.
        return people; // returing people
    }
}class Solution {
    long ans = 0;int s = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
       List<List<Integer>> graph = new ArrayList<>();
        s = seats;
        for(int i=0;i<=roads.length;i++){
            graph.add(new ArrayList());
        }
        for(int []r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        // making the list of the connected childs 
        
        dfs(0,0,graph);
        return ans;
    }
    
    public int dfs(int curr_node, int prev_node, List<List<Integer>> graph){
        int people = 1;
        for(int child : graph.get(curr_node)){
            if(child == prev_node) continue; // acting like  a visited, no need to write visited 
            people += dfs(child,curr_node,graph); // calculating the people 
        }
        if(curr_node != 0) ans += (people + s - 1)/s; // ceil value of the number of cars wrt to seats of single car.
        return people; // returing people
    }
}