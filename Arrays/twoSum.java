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
// Solving using HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target- nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,1};

    }
}
