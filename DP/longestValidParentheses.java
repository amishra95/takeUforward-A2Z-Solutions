class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        int count = 0;
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')' && i > 0) {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = dp[i - 1] + 2;            // Case 1: "...()"
                } else {
                    int j = i - dp[i] - 1;                // Case 2: "...))"
                    if (j >= 0 && s.charAt(j) == '(') {
                        dp[i + 1] = dp[i] + 2 + dp[j];
                    }
                }
            }
            count = Math.max(count, dp[i + 1]);
        }

        return count;
    }
}
