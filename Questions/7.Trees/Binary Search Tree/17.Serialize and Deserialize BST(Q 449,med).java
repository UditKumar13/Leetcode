/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val + " ");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
    
    // preorder traversal 
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] s = data.split(" ");
        return constructBSTpre(s,0,s.length-1);
    }
    
    public TreeNode constructBSTpre(String[] s, int st, int end){
        if(st > end) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(s[st]));
        
        int index;
        for(index=st+1;index<=end;index++){
            if(Integer.parseInt(s[st]) < Integer.parseInt(s[index])) break;
        }
        
        root.left = constructBSTpre(s,st+1,index-1);
        root.right = constructBSTpre(s,index,end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;




// approach 2 : Inorder


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void inorder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        
        inorder(root.left,sb);
        sb.append(root.val + " ");
        inorder(root.right,sb);
    }
    
    // preorder traversal 
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        inorder(root,sb);
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] s = data.split(" ");
        return constructBSTin(s,0,s.length-1);
    }
    
    public TreeNode constructBSTin(String[] s, int low, int high){
        if(low > high) return null;
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(Integer.parseInt(s[mid]));
        root.left = constructBSTin(s,low,mid-1);
        root.right = constructBSTin(s,mid+1,high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;