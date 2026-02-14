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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> k = new ArrayList<>();
        recursion(k, root, 0);

        return k;
       
    }

    public void recursion(List<List<Integer>> list, TreeNode root, int height){
        if(root == null){
            return;
        }
        if(height >= list.size()){
            list.add(new LinkedList<Integer>());
        }
        list.get(height).add(root.data);
        recursion(list, root.left, height+1);
        recursion(list, root.right, height+1);
    }
}
