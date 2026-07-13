class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

    for(int i = 3; i <= n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
    }
}

// Memoization approach below
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return dp[n] = func(n, dp);

    }

    public int func(int n, int[] dp){
        if(n <= 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n]
 =func(n-1, dp) + func(n-2, dp);
     }
}
