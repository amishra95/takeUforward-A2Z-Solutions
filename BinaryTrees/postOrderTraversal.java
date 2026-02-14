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
    public List<Integer> postorder(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            recursion(root, list);

            return list;

    }

    public void recursion(TreeNode root, List<Integer> array){
        if(root == null){
            return;
        }
        recursion(root.left, array);
        recursion(root.right, array);
        array.add(root.data);


    }
}
