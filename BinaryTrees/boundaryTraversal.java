/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class Solution {
  public List<Integer> boundary(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;

    if(!isLeaf(root)){
	        list.add(root.data);
	    }

    leftTraversal(list, root.left);
    insertLeafNode(list, root);
    rightTraversal(list, root.right);

    return list;

  }

  public boolean isLeaf(TreeNode root) {
    if (root != null && root.left == null && root.right == null) {
      return true;
    }
    return false;
  }

  public void leftTraversal(List<Integer> list, TreeNode root) {
   
    if (root == null) return;
    TreeNode leftNode = root;

    while (leftNode != null) {

      if (isLeaf(leftNode)) {
        break;
      }
      list.add(leftNode.data);

      if (leftNode.left != null) {
        leftNode = leftNode.left;
      } else {
        leftNode = leftNode.right;
      }
    }
  }

  public void rightTraversal(List<Integer> list, TreeNode root) {
    if (root == null) return;
TreeNode rightNode = root;
    Stack<Integer> stack = new Stack<>();

    while (rightNode != null) {
      if (isLeaf(rightNode)) {
        break;
      }
      stack.push(rightNode.data);

      if (rightNode.right != null) {
        rightNode = rightNode.right;
      } else {
        rightNode = rightNode.left;
      }
    }

    while (!stack.isEmpty()) {
      list.add(stack.pop());
    }
  }

  public void insertLeafNode(List<Integer> list, TreeNode root){
    if(root == null){
        return;
    }

    insertLeafNode(list, root.left);
    insertLeafNode(list, root.right);
    if(isLeaf(root)){
	        list.add(root.data);
	    }

  }
}
