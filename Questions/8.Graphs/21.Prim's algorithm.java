import java.util.*; 

class Node 
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
}

class Main
{
    void primsAlgo(ArrayList<ArrayList<Node>> adj, int N)
    {

        // Prim's algorithm to find the minimum spanning tree (MST) of a graph
        int key[] = new int[N];
        int parent[] = new int[N]; 
        boolean mstSet[] = new boolean[N]; 
        for(int i = 0;i<N;i++) {
        	key[i] = 100000000; 
        	mstSet[i] = false; 
        }

        key[0] = 0;
        parent[0] = -1; 
        

        for(int i = 0;i<N-1;i++) {
        	int mini = 100000000, u = 0; 
        	for(int v = 0;v<N;v++) {
        		if(mstSet[v] == false && key[v] < mini) {
        			mini = key[v]; 
        			u = v; 
        		}
        	}

        	mstSet[u] = true;
     

        	for(Node it: adj.get(u)) {
        		if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
        			parent[it.getV()] = u; 
        			key[it.getV()] = it.getWeight(); 
        		}
        	}
        }

        for(int i = 1;i<N;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node>());
			
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));
		
		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));
		
		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));
		
		Main obj = new Main(); 
		obj.primsAlgo(adj, n); 
		
    }
}


// TC : Time Complexity: O(N^2). Going through N Node for N-1 times

Space Complexity: O(N). 3 arrays of size N




// optmisied approach :


import java.util.*;

class Node implements Comparator < Node > {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {}

    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}

class Main {
    void primsAlgo(ArrayList < ArrayList < Node >> adj, int N) {
        // Prim's algorithm to find the minimum spanning tree (MST) of a connected,
        //  weighted, undirected graph
        // Using a priority queue to efficiently get the minimum weight edge
        // Initialize key values, parent array, and mstSet array
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

        PriorityQueue < Node > pq = new PriorityQueue < Node > (N, new Node());

        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(key[0], 0));
        // Run the loop till all the nodes have been visited
        // because in the brute code we checked for mstSet[node] == false while computing the minimum
        // but here we simply take the minimal from the priority queue, so a lot of times a node might be taken twice
        // hence its better to keep running till all the nodes have been taken. 
        // try the following case: 
        // Credits: Srejan Bera
        // 6 7 
        // 0 1 5 
        // 0 2 10 
        // 0 3 100 
        // 1 3 50 
        // 1 4 200
        // 3 4 250
        // 4 5 50 
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;

            for (Node it: adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList < ArrayList < Node > > adj = new ArrayList < ArrayList < Node > > ();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList < Node > ());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        Main obj = new Main();
        obj.primsAlgo(adj, n);

    }
}


Time Complexity: O(NlogN). N iterations and logN for priority queue

Space Complexity: O(N). Three arrays and priority queue

