class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        // Step 1: Sort so that nums[j] <= nums[i] for all j < i
        Arrays.sort(nums);

        int[] dp   = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen    = 1;
        int lastIndex = 0;

        // Step 2: For each i, find the largest subset ending at i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // nums[i] % nums[j] == 0 works because array is sorted
                // nums[j] is always <= nums[i]
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i]   = dp[j] + 1;
                    prev[i] = j;
                }
            }

            // Track where the longest subset ends
            if (dp[i] > maxLen) {
                maxLen    = dp[i];
                lastIndex = i;
            }
        }

        // Step 3: Backtrack using prev[] to reconstruct the subset
        List<Integer> list = new ArrayList<>();
        int i = lastIndex;
        while (i != -1) {
            list.add(nums[i]);
            i = prev[i];
        }

        Collections.reverse(list);
        return list;
    }
}
