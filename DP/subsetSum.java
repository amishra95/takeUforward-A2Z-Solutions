class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        
        boolean dp[] = new boolean[target+1];

        dp[0] = true;

        for(int n: arr){
            for(int j = target; j>= n; j--){
                dp[j] = dp[j]|| dp[j-n];
            }

        }
        return dp[target];
        


      
    }
}
