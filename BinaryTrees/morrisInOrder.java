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
     public List<Integer> getInorder(TreeNode root) {
        // List to store inorder traversal
        List<Integer> inorder = new ArrayList<>(); 
        // Pointer to the current node
        TreeNode cur = root; 

        while (cur != null) {
            if (cur.left == null) {
                // Add current node's value and move to right child
                inorder.add(cur.data); 
                cur = cur.right; 
            } else {
                // Find the predecessor
                TreeNode prev = cur.left; 
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                /* Establish a temporary link and move to the
                left child */
                if (prev.right == null) {
                    prev.right = cur; 
                    cur = cur.left; 
                } else {
                /* Remove the temporary link, add current node's value
                and move to the right child */    
                    prev.right = null; 
                    inorder.add(cur.data); 
                    cur = cur.right; 
                }
            }
        }
        // Return inorder traversal
        return inorder; 
    }
}
