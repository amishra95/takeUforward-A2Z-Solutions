class Solution {
    public int numberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){          // longer found
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];             // reset count
                    } else if(dp[j] + 1 == dp[i]){  // same length found
                        cnt[i] += cnt[j];            // add count
                    }
                }
            }
        }

        int maxLen = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            maxLen = Math.max(maxLen, dp[i]);
        }

        for(int i = 0; i < n; i++){
            if(dp[i] == maxLen){
                result += cnt[i];
            }
        }

        return result;
    }
}
