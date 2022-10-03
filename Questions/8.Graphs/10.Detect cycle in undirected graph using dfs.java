ArrayList <ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);


        Solution obj = new Solution();
        boolean ans = obj.isCycle(V, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }
}


class Solution {
    public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList < ArrayList 
    < Integer >> adj) {
        vis[node] = true;
        for (Integer it: adj.get(node)) {
            if (vis[it] == false) {
                if (checkForCycle(it, node, vis, adj) == true)
                    return true;
            } else if (it != parent)
                return true;
        }

        return false;
    }
    // 0-based indexing Graph
    public boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }
}

Time Complexity: O(N)

Space Complexity: O(N)