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
    void recoverTree(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode first = null;
        TreeNode second = null;

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).data > list.get(i+1).data){
                if(first == null){
                    first = list.get(i);
                }
                second = list.get(i+1);
            }

        }
        swap(first, second);

    }


    public void inorder(TreeNode root, List<TreeNode> list){
       if(root == null){
            return;
       }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
       
    }

    public void swap(TreeNode a, TreeNode b){
        if(a != null && b != null){
            int temp = a.data;
            a.data = b.data;
            b.data = temp;
        }
    }

    }
