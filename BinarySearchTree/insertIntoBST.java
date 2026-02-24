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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.data){
        
            root.left = insertIntoBST(root.left, val);

        }
        
        if(val > root.data){
            root.right = insertIntoBST(root.right, val);

        }
      


    return root;

    }
}
