class Solution {
    public int targetSum(int n, int target, int[] nums) {
        
      int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(Math.abs(target) > sum) return 0;
        if((target+sum) % 2 != 0) return 0;

      int  P = (sum+ target)/2;
            int MOD = 1000000007;


        int dp[] = new int[P+1];
        dp[0] = 1;

        for(int i = 0; i < n; i++){
            for(int j= P; j >= nums[i]; j--){
                                dp[j] = (dp[j] + dp[j - nums[i]]) % MOD;

            }
        }
            return dp[P];
    }
}

