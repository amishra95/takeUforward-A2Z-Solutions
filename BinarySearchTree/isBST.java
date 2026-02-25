/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

//root.left.val == root.right) and (root.left != root.right)
class Solution {
    public boolean isBST(TreeNode root) {
        if(root == null){
            return true;
        }
       List<Integer> k = new ArrayList<>();
       
       inorderTraversal(root, k);
       for(int i = 0; i < k.size()-1; i++){
           //Checks for the first violation
            if(k.get(i) >= k.get(i+1)){
                return false;
            }
       }
        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);

    }

}
