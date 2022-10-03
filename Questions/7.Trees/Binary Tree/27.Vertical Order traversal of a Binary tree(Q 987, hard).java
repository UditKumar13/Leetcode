/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public class Pair{
        TreeNode t;
        int ht;
        int level;
        Pair(TreeNode t, int ht,int level){
            this.t=t ;
            this.ht = ht;
            this.level = level;
        }
    }
    
    
     class  Sorting implements Comparator<secondPair>{
        @Override
        public int compare(secondPair a, secondPair b){
            
            if(a.level == b.level){
                return a.val - b.val;
            }
            return a.level - b.level;
        }
    }
    
      class  secondPair{
        int val;
        int level;
        
        secondPair(int val,int level){
            this.val =val;
            this.level = level;
        }
        
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map <Integer,List<secondPair>> map = new TreeMap<Integer,List<secondPair>>();
        Queue<Pair> q = new LinkedList<Pair>();
        
        q.add(new Pair(root,0,1));
        int myLevel = 0;
        while( ! q.isEmpty()){
            int size = q.size();
            myLevel++;
            for(int i=0;i<size;i++){
                 Pair curr = q.poll();
                int curr_ht = curr.ht;
                if(map.containsKey(curr_ht)){
                    List<secondPair> li = map.get(curr_ht);
                    li.add(new secondPair(curr.t.val,myLevel));
                    map.put(curr_ht,li);
                }
                
                else{
                    List<secondPair> li = new ArrayList<>();
                    li.add(new secondPair(curr.t.val,myLevel));
                    map.put(curr_ht,li);
                }
                
                if(curr.t.left != null){
                    q.add(new Pair(curr.t.left,curr.ht -1,myLevel));
                }
                
                 if(curr.t.right != null){
                    q.add(new Pair(curr.t.right,curr.ht + 1,myLevel));
                }
            }
            
        }
        

        
        for(Map.Entry <Integer,List<secondPair>> entry : map.entrySet()){
            List<secondPair> li = entry.getValue();
            Collections.sort(li, new Sorting());
            List<Integer> everyVertical = new ArrayList<>();
            for(secondPair p : li){
                int val = p.val;
                everyVertical.add(val);
            }
            ans.add(everyVertical);
        }
        
        
        return ans;
    }
}