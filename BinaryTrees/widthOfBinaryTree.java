class Solution {

    static class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0L));
        int width = 0;

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            long levelStart = queue.peek().index;
            long index = 0;

            for (int i =
