class Solution {
    
    boolean isPalin(String s, int l, int r){  
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = i;
            
            for(int j = 0; j <= i; j++){
                if(isPalin(s, j, i)){  /
                    if(j == 0){
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
