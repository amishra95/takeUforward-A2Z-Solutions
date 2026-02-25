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
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        int ksmall = list.get(k-1);
        int klarg = list.get(list.size()-k);

        List<Integer> res = new ArrayList<>();
        res.add(ksmall);
        res.add(klarg);

        return res;

    }


    public void inorderTraversal(TreeNode root, List<Integer> list){
        
        if(root != null){
         inorderTraversal(root.left, list);
         list.add(root.data);
         inorderTraversal(root.right, list);
        }
    }

}
