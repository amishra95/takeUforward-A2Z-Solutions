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
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, new ArrayList<>(), result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> current, List<List<Integer>> result) {
        if (root == null) return;
        
        current.add(root.data);
        
        // If it's a leaf node, add the current path to result
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            helper(root.left, current, result);
            helper(root.right, current, result);
        }
        
        // Backtrack
        current.remove(current.size() - 1);
    }
}
