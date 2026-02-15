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
    public boolean isSymmetric(TreeNode root) {
       if(root == null){
        return true;
       }

       return help(root.left, root.right);

    }

    public boolean help(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }

        if(a.data != b.data){
            return false;
        }

    
        return help(a.left, b.right)&& help(a.right, b.left);
    
    }


}
