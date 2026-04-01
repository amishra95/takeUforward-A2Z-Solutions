class Solution {
    public int stockBuySell(int[] arr, int n, int k) {
        
        int[] buy  = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int price = arr[i];

            for (int j = 1; j <= k; j++) {
                buy[j]  = Math.max(buy[j],  sell[j-1] - price);
                sell[j] = Math.max(sell[j], buy[j]    + price);
            }
        }

        return sell[k];
    }
}
