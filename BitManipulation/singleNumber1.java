class Solution {
    public int singleNumber(int[] nums) {
        //your code goes here

    Arrays.sort(nums);

    for(int i = 0; i < nums.length-1; i+=2){
        if(nums[i] != nums[i+1]){
            return nums[i];
        }
    }
        return nums[nums.length-1];
    }
}
// 2nd Solution using Single Number and Xor
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
    for(int i = 0; i < nums.length; i++){
        a ^= nums[i];
    }

        return a;

    }
}

