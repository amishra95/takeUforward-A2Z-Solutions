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
    public boolean twoSumBST(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        return helper(root, k, set);

    }
    


    public boolean helper(TreeNode root, int k, HashSet<Integer> set ){
        if(root == null){
            return false;
        }
        int b = k - root.data;
        
        if(set.contains(b)){
            return true;
        }
        set.add(root.data);
        
        return helper(root.left, k, set) || helper(root.right, k, set);
    }

}
