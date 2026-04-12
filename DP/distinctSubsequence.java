class Solution {
    public int distinctSubsequences(String s, String t) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(t == null || t.length() == 0){
            return 1;
        }

        int n = s.length();
        int m = t.length();
        long MOD = 1000000007L;


        long dp[][] = new long [n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i =1; i <= n; i++){
            for(int j = 1; j <=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])% MOD;
                }
                      else{            
                          dp[i][j] = dp[i-1][j];
                      }

            }
        }

        return (int)dp[n][m];

    }
}
