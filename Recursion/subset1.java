class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtrack(nums, 0, 0, result); // track running sum, not the subset itself
        return result;
    }

    public void backtrack(int[] nums, int index, int currentSum, List<Integer> result) {
        result.add(currentSum); // add current sum at every node

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentSum + nums[i], result);
        }
    }
}
