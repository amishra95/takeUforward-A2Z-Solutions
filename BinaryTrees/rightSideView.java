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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
    return list;
        
    }

    public void helper(TreeNode node, int depth, List<Integer> arr){
        if(node == null){
            return;
        }
     
     if(depth == arr.size()){
        list.add(node.val);
     }
     helper(node.right, depth+1, arr);
     helper(node.left, depth+1, arr);

    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
            if(root == null){
                return list;
            }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(i == len-1){
                    list.add(node.data);
                }
                if (node.left != null){
                  queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }

        }

        return list;
    }
}
