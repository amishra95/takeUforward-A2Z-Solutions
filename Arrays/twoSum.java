// Solving using Array method.
class Solution {
    public int[] twoSum(int[] nums, int target) {
    
            int[] a = new int[2];
        for(int i = 0; i < nums.length-1; i++){
           for(int j = 1; j < nums.length-1 ; j++){
                if(target - nums[i] == nums[j]){
                     a = {i,j};
                }

        }
        return a;
    }
        return null;

    }
}
