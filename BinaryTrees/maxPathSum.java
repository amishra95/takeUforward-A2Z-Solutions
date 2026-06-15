class Solution {
    private int globalSum; 

    public int maxPathSum(TreeNode root) {
        globalSum = Integer.MIN_VALUE;
        sum(root);
        return globalSum;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = Math.max(sum(root.left), 0);
        int rightSum = Math.max(sum(root.right), 0);

        int currentSum = leftSum + rightSum + root.data;

        globalSum = Math.max(globalSum, currentSum);

        return root.data + Math.max(leftSum, rightSum);
    }
}
