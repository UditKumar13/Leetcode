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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) return zigzag;
        int decision = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> currNodes = new ArrayList<>();
            for(int i=0;i<size;i++){
            TreeNode temp = q.remove();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            currNodes.add(temp.val);
            }
            if(decision % 2 == 0) {
                Collections.reverse(currNodes);
                zigzag.add(currNodes);
            }else{
                zigzag.add(currNodes);
            }
            
            
         decision++;   
        }
        
        return zigzag;
    }
}





// Approach 2 

// more optimal Striver 


import java.util.*;
class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
class TUF {
    public static ArrayList < ArrayList < Integer >> zigzagLevelOrder(Node root) {
        Queue < Node > queue = new LinkedList < Node > ();
        ArrayList < ArrayList < Integer >> wrapList = new ArrayList < > ();

        if (root == null) return wrapList;

        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList < Integer > subList = new ArrayList < Integer > (levelNum);
            for (int i = 0; i < levelNum; i++) {
                int index = i;
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag == true) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String args[]) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ArrayList < ArrayList < Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}

