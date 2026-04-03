class Solution {
    public int minDifference(int[] arr, int n) {
        int totalSum = 0;
        int closestSum = 0 ;
     

    for(int j = 0; j < n; j++){
            totalSum += arr[j];
        }

    boolean[] dp = new boolean[totalSum/2 +1];
    dp[0] = true;
       
    for(int a: arr){
        for(int j = totalSum/2; j>=a; j--){
            dp[j] = dp[j] || dp[j-a];
            
        }
    }

    for(int j = totalSum/2; j >= 0; j--){
        if(dp[j]){
            closestSum = j;
            break;
        }
    }

   return  totalSum - 2 * closestSum;
    
       


    }
}
