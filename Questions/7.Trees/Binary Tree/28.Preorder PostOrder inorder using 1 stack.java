import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
}
class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}
public class TUF {
    public static void allTraversal(TreeNode root, List < Integer > pre, List < Integer > in , List < Integer > post) {
        Stack < Pair > st = new Stack < Pair > ();
        st.push(new Pair(root, 1));
        
        if (root == null) return;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2 
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in 
            // increment 2 to 3 
            // push right 
            else if (it.num == 2) { in .add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // don't push it back again 
            else {
                post.add(it.node.val);
            }
        }
 

    }

// TC : O(3n)

// SC : O(4n)