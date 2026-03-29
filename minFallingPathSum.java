class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // handle single cell
        if (m == 1) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[0][j]);
            }
            return min;
        }

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int above     = dp[i-1][j];
                int diagLeft  = (j > 0)     ? dp[i-1][j-1] : Integer.MAX_VALUE / 2;
                int diagRight = (j < n - 1) ? dp[i-1][j+1] : Integer.MAX_VALUE / 2;
                dp[i][j] = matrix[i][j] + Math.min(above, Math.min(diagLeft, diagRight));
            }
        }

        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minimum = Math.min(minimum, dp[m-1][j]);
        }

        return minimum;
    }
}
