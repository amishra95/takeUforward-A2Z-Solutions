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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();
        
         if(root == null){
            return list;
        }


        helper(list, root, 0);


    return list;


    }

    public void helper(List<List<Integer>> list, TreeNode root, int height){
        if(root == null){
            return ; 
        }
    
        if(height >= list.size()){
            list.add(new LinkedList<Integer>());
        }
        
        if(height % 2 ==0){
            list.get(height).add(root.data);
        }
        else{
        list.get(height).add(0,root.data);
        }

        helper(list, root.left, height+1);
        helper(list, root.right, height+1);

    }

}
