class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
    
    for(int num:nums){
        map.put(num, map.getOrDefault(num, 0)+1);

        if(map.get(num) > n/2){
            return num;
        }
    }
    
    return -1;

    }
}


class Solution{
  public int majorityElement(int[] nums){

  int n = nums.length; 

  for(int i = 0; i <n; i++){
    int count = 0;
    for(int j = 0; j < n; j++){
      if(nums[i] == nums[j]){
        count++;
      }
      if(count > n/2){
        return nums[i];
      }
    }
    return -1;
  }
  }
