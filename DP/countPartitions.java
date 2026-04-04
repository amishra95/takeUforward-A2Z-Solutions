class Solution {
    public int countPartitions(int n, int diff, int[] arr) {
        int mod = 1000000007;
        int totalSum = 0;

        for(int j = 0; j < n; j++){
            totalSum += arr[j];
        }

        if((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) return 0;

        int K = (totalSum - diff) / 2;

        int dp[] = new int[K+1];
        dp[0] = 1;

        for(int a: arr){
            if(a == 0){
                for(int j = K; j >= 0; j--){
                    dp[j] = (dp[j] * 2) % mod;
                }
                continue;
            }
            for(int j = K; j >= a; j--){
                dp[j] = (dp[j] + dp[j-a]) % mod;
            }
        }

        return dp[K];
    }
}
