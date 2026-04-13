class Solution {
    public int maxCoins(int[] nums) {
        
        // add boundaries of 1 on both sides
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i-1];
        }
        
        int m = arr.length;
        int dp[][] = new int[m][m];

        for(int len = 2; len < m; len++){
            for(int i = 0; i < m - len; i++){
                int j = i + len;
                for(int k = i+1; k < j; k++){
                    int cost = dp[i][k] + dp[k][j] 
                             + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.max(dp[i][j], cost);
                }
            }
        }
        return dp[0][m-1];
    }
}
