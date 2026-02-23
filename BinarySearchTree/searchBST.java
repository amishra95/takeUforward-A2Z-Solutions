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
    public TreeNode searchBST(TreeNode root, int val) {
       if(root == null || root.data == val)
     {
        return root;
     }

     if(val< root.data){
        return  searchBST(root.left, val);
     }
     else
       return searchBST(root.right, val);
     



    }
}
