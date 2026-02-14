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
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);

        return list;
    }

    public void recursive(TreeNode root,List<Integer> array){
        if(root == null){
            return;
        }
       
        array.add(root.data);
        recursive(root.left, array);
        recursive(root.right, array);

        
        
    }


}
