// Another way to solve this
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] != 0){
            nums[j] = nums[i];
            j++;
        }
    }
        while(j < nums.length){
            nums[j++] = 0;
         }
    
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

    for(int i = 0; i < nums.length; i++){
        if(nums[i] != 0){
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            index++;

        }
    }
        
    }
}
