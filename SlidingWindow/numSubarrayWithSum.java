class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        
        int sum = 0;
        int result = 0;
        
        for (int num : nums) {
            sum += num;
            if (sum - goal >= 0) {
                result += count[sum - goal];
            }
            count[sum]++;
        }
        
        return result;
    }
}
