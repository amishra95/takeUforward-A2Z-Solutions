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
    public List<List<Integer>> findLeaves(TreeNode root) {
       
        List<List<Integer>> list = new ArrayList<>();
        getHeight(root, list);

        return list;


    }

    public int getHeight(TreeNode root, List<List<Integer>> list){
        
        if(root == null){
            return -1;
        }

        int left = getHeight(root.left, list);
        int right = getHeight(root.right, list);
        int height = Math.max(left, right) + 1;  

        if(list.size() == height){
            list.add(new ArrayList<>());
        }

    
    list.get(height).add(root.val);
    return height;
    
    }

    

}
