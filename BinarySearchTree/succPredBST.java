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
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int pred = -1;
        int succ = -1;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == key){
                if(i > 0){
                    pred = list.get(i-1);
                }
                if(i < list.size()-1){
                    succ = list.get(i+1);
                }
                break;
            }
        }
            List<Integer> result = new ArrayList<>();
            result.add(pred);
            result.add(succ);

            return result;
        
    
    }


    public void inorder(TreeNode root, List<Integer> list){
        
        if(root == null){
            return;
        }

    inorder(root.left, list);
    list.add(root.data);
    inorder(root.right, list);


    }
}
