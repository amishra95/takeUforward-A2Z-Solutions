class Solution {
    public boolean equalPartition(int n, int[] arr) {

        int totalSum = 0;
        
        for(int num: arr){
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;


        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num:arr){
            for(int j = target; j>=num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
            return dp[target];
    }
}
