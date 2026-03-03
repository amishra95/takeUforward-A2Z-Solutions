

// Solved it using Arrays Sort. 
class Solution {
    public int kthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);

    for(int i = nums.length; i >0; i--){
        return nums[nums.length-k];
        
    }

    return 0;

    }
}
