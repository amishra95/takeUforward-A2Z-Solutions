class Solution {
    public int ninjaTraining(int[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return 0;
        }  
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][]dp = new int[n][m];
         
         for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
           
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int hello = 0;
                for(int k = 0; k < m; k++){
                    if(k != j){
                        hello = Math.max(hello, dp[i-1][k]);
                    }
                    
                }
                    dp[i][j] = matrix[i][j] + hello;

            }

        }
        int ans = 0;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dp[n-1][j]);
        }
        return ans;
    
    }

}
