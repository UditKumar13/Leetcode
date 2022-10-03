class Solution {
    public int floorBst(TreeNode root, int key){
        
        int floor = -1;
        while (root != null){
            
            if(root.val == key){
                floor = root.val;
                
            }
            if(root.val > key){
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }
        
        return floor;
    }
}

// Floor 
class Solution {
    public int CeilBst(TreeNode root, int key){
        
        int cell= -1;
        while (root != null){
            
            if(root.val == key){
                ceil = root.val;
                return ceil;
            }
            if(key > root.data){
                root = root.right;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        
        return ceil;
    }
}


// Ceiling 