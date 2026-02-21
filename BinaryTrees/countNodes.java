/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public int countNodes(TreeNode root) {
    
      if (root == null) return 0;

    int left = countNodes(root.left);
    int right = countNodes(root.right);

    return 1+left+right;
    
    }

    
}
