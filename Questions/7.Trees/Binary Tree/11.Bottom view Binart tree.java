class Solution {
    
    
    public ArrayList <Integer> bottomView(){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map <Integer,Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        
        root.hd = 0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.hd;
            map.put(hd,temp.data);
            if(temp.left != null){
                temp.left.hd = hd -1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
            
        }
        
        // now as the tree map stores the key in sorted order
        for(map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}

// map will store 
  vertical height, node

// 

// in top view we will just add one condition, that we will always check the map, 
if the current, ht is already present in map, if yes we will not update it blindly 
that is the difference.
