class Solution {
    public int minCost(int n, List<Integer> cuts) {
        
        // add boundaries
        int[] c = new int[cuts.size() + 2];
        c[0] = 0;
        c[c.length - 1] = n;
        for(int i = 1; i <= cuts.size(); i++){
            c[i] = cuts.get(i-1);
        }
        Arrays.sort(c);


        //key explanation point and view, with solution and value index)
        int m = c.length;
        int dp[][] = new int[m][m];

        for(int len = 2; len < m; len++){
            for(int i = 0; i < m - len; i++){
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1; k < j; k++){
                    int cost = dp[i][k] + dp[k][j] + c[j] - c[i];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][m-1];
    }
}
