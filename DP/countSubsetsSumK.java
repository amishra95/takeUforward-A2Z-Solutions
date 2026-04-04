class Solution {
  public int perfectSum(int[] arr, int K) {
    int mod = 1000000007;

    int dp[] = new int[K + 1];
    dp[0] = 1;

    for (int a : arr) {

      for (int j = K; j >= a; j--) {
        dp[j] = (dp[j] + dp[j - a]) % mod;
      }
    }

    return dp[K];
  }
}
