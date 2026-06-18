/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class BSTIterator {
       private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
           pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.data;
        }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }    
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
