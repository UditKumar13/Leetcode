class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
    // iterative solution 
    if(root == null) return false;
    Stack <TreeNode> path = new Stack<>();
    Stack <Integer> sub = new Stack<>();
    path.push(root);
    sub.push(root.val);
    while(!path.isEmpty()){
        int tempVal = sub.pop();
        TreeNode temp = path.pop();
        if(temp.left == null && temp.right == null && tempVal == targetSum) return true;
        if(temp.left != null){
            path.push(temp.left);
            sub.push(temp.left.val + tempVal);
        }if(temp.right != null){
            path.push(temp.right);
            sub.push(temp.right.val + tempVal);
        }
    }
    return false;
    }
}

// Iterative 



// Recursion 

class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
    // Recursive solution 
    if(root == null) return false;
    if(root.left == null && root.right == null && root.val == targetSum) return true;
    return (hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val) );
    }
}