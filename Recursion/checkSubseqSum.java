class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return backtrack(nums, 0, 0, k);
    }

    private boolean backtrack(int[] nums, int index, int currentSum, int k) {
        // Found a subsequence with sum k
        if (currentSum == k) return true;

        // Exhausted all elements
        if (index == nums.length) return false;

        // Include current element OR exclude it
        return backtrack(nums, index + 1, currentSum + nums[index], k)  // include
            || backtrack(nums, index + 1, currentSum, k);               // exclude
    }
}
