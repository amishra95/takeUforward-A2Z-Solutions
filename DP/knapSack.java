class Solution {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
      
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[W];
  
    }
}
