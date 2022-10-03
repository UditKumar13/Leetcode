import java.util.*;
class Node {
  int data;
  Node  left,  right;
  Node(int data)
  {
      this.data=data;
      left=null;
      right=null;
  }
}
class TUF{
static void reorder(Node  root) {
  if (root == null) return;
  int child = 0;
  if (root . left!=null) {
    child += root . left . data;
  }
  if (root . right!=null) {
    child += root . right . data;
  }

  if (child < root . data) {
    if (root . left!=null) root . left . data = root . data;
    else if (root . right!=null) root . right . data = root . data;
  }

  reorder(root . left);
  reorder(root . right);

  int tot = 0;
  if (root . left!=null) tot += root . left . data;
  if (root . right!=null) tot += root . right . data;
  if (root . left!=null || root . right!=null) root . data = tot;
}


// TC : O(n)

// SC : O(n)

