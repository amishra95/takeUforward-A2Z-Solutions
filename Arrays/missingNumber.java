class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum1 = (n*(n+1))/2;
        int sum2 = 0;

        for(int a:nums){
            sum2 += a;
        }
        int missing = sum1-sum2;

return missing;
        
    }
}
