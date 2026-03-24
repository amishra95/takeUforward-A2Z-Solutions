class Solution {
    public int houseRobber(int[] money) {
        if (money == null || money.length == 0) return 0;
        if (money.length == 1) return money[0];

        int n = money.length;
        int[] skipLastHouse = new int[n - 1];
        int[] skipFirstHouse = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            skipLastHouse[i] = money[i];
            skipFirstHouse[i] = money[i + 1];
        }

        return Math.max(robHelper(skipLastHouse), robHelper(skipFirstHouse));
    }

    private int robHelper(int[] money) {
        if (money.length == 1) return money[0];
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        return dp[money.length - 1];
    }
}
