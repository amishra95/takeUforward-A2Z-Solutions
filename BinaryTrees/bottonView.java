```java
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
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }

       TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int hd = curr.getValue();

            map.put(hd, node.data);
        
         if(node.left != null){
            queue.offer(new Pair<>(node.left, hd-1));
        }
        if(node.right != null){
            queue.offer(new Pair<>(node.right, hd+1));
        }

        }
        list.addAll(map.values());
        return list;
    }
}
```
