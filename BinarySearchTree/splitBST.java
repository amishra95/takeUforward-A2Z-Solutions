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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null){
           // creation of TreeNode array, which can be used
            return new TreeNode[]{null, null};
        }

        if(root.val <= target){
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0];
            return new TreeNode[]{root, res[1]};
        }

        else{
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1];
            return new TreeNode[]{res[0], root};

        } 
        
        
        
    }

}
