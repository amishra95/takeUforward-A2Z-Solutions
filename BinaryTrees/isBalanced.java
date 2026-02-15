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
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }

    int leftH = height(root.left);
    int rightH = height(root.right);

    if(Math.abs(leftH - rightH <= 1 && isBalanced(root.left)&& isBalanced(root.right))){
        return true;
    }

    return false;

    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

    int left = height(root.left);
    int right = height(root.right);

    return 1+Math.max(left, right);
    }
        
    
}
