class Solution {
    public int frogJump(int[] heights, int k) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return 0;
        }

        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        return dp[n - 1];
    }
}
