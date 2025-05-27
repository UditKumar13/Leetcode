import java.util.*; 

class Main
{
	private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				dfs(it, st, adj, vis); 
			}
		}
        // uses topological sort to store the nodes in a stack
		// so that we can process them in reverse order later
		// in order to store according to finishing time
		// this is important for the kosaraju's algorithm
		st.push(node); 
	}

	private void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[]) {
		vis[node] = 1;
		System.out.print(node + " "); 
		for(Integer it : transpose.get(node)) {
			if(vis[it] == 0) {
				revDfs(it, transpose, vis); 
			}
		}
	}

    void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n]; 
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, st, adj, vis); 
        	}
        }

        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			transpose.add(new ArrayList<Integer>());
		// create the transpose of the graph
		// by reversing the direction of the edges

		for(int i = 0;i<n;i++) {
			vis[i] = 0; 
			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i);
				// add the edge in the reverse direction 
			}
		}
		// now we have the transpose of the graph
		// we can now process the nodes in the order of finishing time

		while(st.size() > 0) {
			int node = st.peek(); 
			st.pop(); 
			if(vis[node] == 0) {
				System.out.print("SCC: "); 
				revDfs(node, transpose, vis);
				// call the reverse dfs on the node
				// every call to revDfs will give us one strongly connected component (scc)
				// so we print the nodes in that component 
				System.out.println(); 
			}
		}

    }
    public static void main(String args[])
    {
        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(3).add(2);
		adj.get(3).add(5);
		adj.get(4).add(6);
		adj.get(5).add(4);
		adj.get(6).add(5);

			
		Main obj = new Main(); 
		obj.kosaRaju(adj, n); 
		
    }
}


Time Complexity: O(N+E), DFS+TopoSort

Space Complexity: O(N+E), Transposing the graph

