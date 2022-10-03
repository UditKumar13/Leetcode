 //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
   
        int n = G.length ; 
        if(solve(0, G,color,n,m) == true) return  true ;
        
      
        // where 0 denotes the current node 
        
          return false ; 
      
    }
    
    private boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) return true ;
        // this means we are able to color the nodes with the m colors 
        
        for (int i = 1; i<=m ; i++){
            if (is_Safe(node, G, color, i) == true ){
                color[i] = i ;
                if (solve(node+1, G,color, n,m) == true ) return true   ;
                
                // if not true then backtrack 
                color[i] = 0 ; 
                
            }
        }
        
        return false ; 
    }
    
    private boolean is_Safe(int node, List<Integer>[] G, int [] color, int check_col){
        
        // we have to check the all adjacent nodes of the G 
        
        for (int adj : G[node]){
            if(color[adj] == check_col) return false ; 
        }
        
        return true ; 
    }