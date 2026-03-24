class Solution {
    public int frogJump(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return 0;  // already at destination, no jumps needed
        }

        int n = heights.length;
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(
                dp[i - 1] + Math.abs(heights[i] - heights[i - 1]),  
                dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) 
            );
        }

        return dp[n - 1];
    }
}
