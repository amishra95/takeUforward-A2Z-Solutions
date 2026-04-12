class Solution {
    public int editDistance(String start, String target) {
        if(start == null || start.length() == 0){
            return target.length();
        }
        if(target == null || target.length() == 0){
            return start.length();
        }

        int n = start.length();
        int m = target.length();

        int dp[][] = new int[n+1][m+1];
        
    for(int i = 0; i <= n; i++){
        dp[i][0] = i;
        }
    
    for(int j = 0; j <= m; j++){
        dp[0][j] = j;
    }

        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=m; j++){
                if(start.charAt(i-1) == target.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],      // replace
                  Math.min(dp[i-1][j],            // delete
                           dp[i][j-1]));           // insert

                }
            }
        }
        return dp[n][m];
    }
}
