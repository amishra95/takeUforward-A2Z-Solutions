class Solution {
    public int numberOfOddSubarrays(int[] nums, int k) {
     int left = 0;
     int right = 0;
     int oddCount = 0;
    int result = 0;
    int tempResult = 0;

    while(right < nums.length){
        if(nums[right] % 2 == 1){
            oddCount++;
            tempResult = 0;
        }
        while(oddCount == k){
            tempResult++;
            if(nums[left] % 2 == 1){
                oddCount--;
            }
            left++;
        }
        result += tempResult;
        right++;
    }

        return result;


       
    }
}
