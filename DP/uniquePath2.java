class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n  = matrix[0].length;

        int[] dp = new int[n];
        if (matrix[0][0] == 1) {
             dp[0] = 0;       // obstacle at start → 0 paths
} 
        else {
             dp[0] = 1;       // no obstacle at start → 1 path
        }

    for (int j = 1; j < n; j++) {
        if (matrix[0][j] == 1) {
            dp[j] = 0;              // obstacle blocks the path
        } else {
            dp[j] = dp[j-1];        // carry forward left value
        }
    }
    for (int i = 1; i < m; i++) {
        // Handle first column separately
        if (matrix[i][0] == 1) {
            dp[0] = 0;
        }

for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 1) {
                dp[j] = 0;          // obstacle — no paths through here
            } else {
                dp[j] += dp[j-1];   // above + left
            }
        }
    }

    return dp[n-1];
}
}
