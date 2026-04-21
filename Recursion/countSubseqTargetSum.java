class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return backtrack(nums, 0, 0, k); 
    }

    public int backtrack(int[]nums, int index, int currentSum, int k){
        if(currentSum == k){
            return 1;
        }
        if(index == nums.length){
            return 0;
        }

        return backtrack(nums, index+1, currentSum+nums[index], k) + backtrack(nums, index+1, currentSum, k);
    }
}
