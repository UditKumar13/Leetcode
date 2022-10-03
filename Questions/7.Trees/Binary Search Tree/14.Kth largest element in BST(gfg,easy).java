class Solution
{
   int counter  = 0;
   int ans = 0;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int k)
    {
        helper(root, k);
        return ans;
    }
    
    public void helper(Node root, int k){
        if(root == null) return;
        helper(root.right,k);
        counter++;
        if(counter  == k) {
            ans = root.data ;
            return;
        }
        helper(root.left,k);
    }
}

// Approach 1 
TC : O(n)
SC : O(1)


// Appraoch 2 :
