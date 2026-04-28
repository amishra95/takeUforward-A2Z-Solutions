class Solution {
    public int smallestDivisor(int[] nums, int limit) {
     int divisor = 1;
     
     while(true){
    
        int sum = 0;
    for(int i = 0; i < nums.length; i++){
        sum += (nums[i] + divisor-1)/divisor;
    }
      if(sum <= limit){
        return divisor;
      }
    
    divisor++;
    
    }
    
    }
