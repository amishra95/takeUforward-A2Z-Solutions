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
    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveInorder(root, list);

        return list;

    }

    private void recursiveInorder(TreeNode root, List<Integer> arr){
        if(root == null){
            return;
        }
        recursiveInorder(root.left, arr);
        arr.add(root.data);

        recursiveInorder(root.right, arr);
        
    }

}
