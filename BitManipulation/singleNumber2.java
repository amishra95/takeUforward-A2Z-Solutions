// Solution using Sorting Method. 
class Solution {
    public int singleNumber(int[] nums) {
       

    Arrays.sort(nums);

    for(int i = 0 ; i < nums.length-1; i+=3){
        if(nums[i] != nums[i+2]){
            return nums[i];
        }
    }    
    return nums[nums.length-1];
         
         }

}
