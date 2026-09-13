//Hardest Problem on Leetcode, I think:
import java.util.Arrays;

class Solution {
    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        int n = prices.length;
        Arrays.sort(prices);

        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + prices[i];
        }

        long[] ans = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int m = queries[i][1]; 

            int lessThanBob = binarySearch(prices, k);
            int moreThanBob = n - lessThanBob;

            int cmax = Math.min(m, lessThanBob);
            int cmin = Math.max(0, m - moreThanBob);

            int low = cmin;
            int high = cmax;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (getLoss(mid, k, m, n, sum) > getLoss(mid + 1, k, m, n, sum)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            ans[i] = getLoss(low, k, m, n, sum);
        }

        return ans;
    }

    public long getLoss(int c, long k, int m, int n, long[] sum) {
        long leftSum = sum[c];
        int rightCount = m - c;
        long rightSum = sum[n] - sum[n - rightCount];
        
        return leftSum + (long) rightCount * 2 * k - rightSum;
    }

    public int binarySearch(int[] prices, int k) {
        int low = 0;
        int high = prices.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
