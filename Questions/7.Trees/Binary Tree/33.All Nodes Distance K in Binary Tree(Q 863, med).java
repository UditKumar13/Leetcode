/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void makeParentPointers(TreeNode root, Map<TreeNode,TreeNode> parent_track){
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                parent_track.put(curr.left,curr);
            }
            
            if(curr.right != null){
                q.offer(curr.right);
                parent_track.put(curr.right,curr);
            }
        }
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map <TreeNode, TreeNode> parent_track = new HashMap<>();
        makeParentPointers(root,parent_track);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        
        Queue <TreeNode> que = new LinkedList<TreeNode>();
        
        que.offer(target);
        visited.put(target,true);
        int curr_Level  = 0;
        while(! que.isEmpty()){
            int size = que.size();
            if(curr_Level == k) break;
            curr_Level++;
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                
                if(curr.left != null && visited.get(curr.left) == null){
                    que.offer(curr.left);
                    visited.put(curr.left,true);
                    
                }
                
                if(curr.right != null && visited.get(curr.right) == null){
                    que.offer(curr.right);
                    visited.put(curr.right,true);
                }
                
                TreeNode parent = parent_track.get(curr);
                
                if( parent != null && visited.get(parent) == null){
                    que.offer(parent);
                    visited.put(parent,true);
                }
            }
        }
        
        List<Integer> allNodesKdis = new ArrayList<>();
        int nodes_Size = que.size();
        for(int i=0;i<nodes_Size;i++){
            TreeNode curr = que.poll();
            allNodesKdis.add(curr.val);
        }
        
        return allNodesKdis;
        
        
    }
}


// TC  : O(n)

// SC : O (n)

