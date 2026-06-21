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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
       int floor = -1;
       int ceil = -1;

        TreeNode curr = root;
        while(curr != null){
            if(curr.data == key){
                floor = key;
                break;
            }
            else if(curr.data > key){
                curr = curr.left;
            }
            else{
                floor = curr.data;
                curr = curr.right;
            }
        }
        curr = root;
        while(curr != null){
            if(curr.data == key){
                ceil = key;
                break;
            }
            else if(curr.data < key){
                curr = curr.right;
            }
            else{
                ceil = curr.data;
                curr = curr.left;
            }
        }
        
        return Arrays.asList(floor, ceil);

    }
}
