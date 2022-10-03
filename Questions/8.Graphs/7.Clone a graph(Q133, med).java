/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public void dfs(Node root, Node copy, Node []vis){
        vis[copy.val] = copy;
        
        for(Node it : root.neighbors){
            if(vis[it.val] == null){
                Node newNode = new Node(it.val);
                copy.neighbors.add(newNode);
                dfs(it,newNode,vis);
                }
            
            else{
                copy.neighbors.add(vis[it.val]);
            }
        }
        
    }
   
    public Node cloneGraph(Node node) {
     if(node == null) return node;
        Node copy = new Node(node.val);
        Node [] vis = new Node [101];
        Arrays.fill(vis,null);
        dfs(node,copy,vis);
        return copy;
    }
}


