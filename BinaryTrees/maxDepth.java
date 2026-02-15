/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int data) { data = data; left = null, right = null }
 * }
 **/

class Solution {
    public int maxDepth(TreeNode root) {
    int max = 0;
    
    if(root == null){
        return 0;
    }

    int leftRoot = maxDepth(root.left);
    int rightRoot = maxDepth(root.right);

    max = Math.max(leftRoot,rightRoot);
    return 1+max;

    

    }
}
