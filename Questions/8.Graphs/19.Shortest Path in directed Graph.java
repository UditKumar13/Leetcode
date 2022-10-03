
class Pair{
    int v;
    int weight;
    
    Pair(int _v, int _weight){
        v = _v;
        weight = _weight;
    }
    
    int getV(){return v;}
    
    int getW(){return weight;}
}

// int main mein 
// shortestPath(0, adj, n);

class Solution {
 
    
public void fillStackTopo(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer>st, boolean []visited){

    visited[node] = true;
    for(Integer it : adj.get(node)){
        if(visited[it] == false){
            fillStackTopo(it,adj,st,visited);
        }
    }
    
    // in post order fill the stack 
    st.push(node);
    // it will generate the topological sort 
}
    
public void shortestPath(int node, ArrayList<ArrayList<Integer>> adj, int N){
    Stack <Integer> st = new Stack<Integer>();
    
    int []dist = new int[N];
    boolean [] visited = new int[N];
    
    for(int i=0;i<N;i++){
        visited[i] = false;
    }
    
    for(int i=0;i<N;i++){
        if( ! visited[i]){
            fillStackTopo(i,adj,st,visited);
        }
    }
    
  // after generating the topo stack now fill the distance list
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[0] = 0; // source node
    while(! st.isEmpty()){
        int node = (int)st.pop();
        if(dist[node] != Integer.MAX_VALUE){
            for(Integer it: adj.get(node)){
                if(dist[node] + it.getW() < dist[it.getV()] ){
                    dist[it.getV()] = dist[node] + it.getW();
                }
            }
            
            
        }
    }
    
}
    
}


// TC : O(n+e * 2)

// Sc : O(2n)



// use topological sort and then after storing the right topo sequence in stack 
// update the weight of the nodes in the topological order 

