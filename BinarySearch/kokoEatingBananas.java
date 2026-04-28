//TLE error, needs binary Search. 
class Solution {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int count = 1;
        
    while(true){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum +=(nums[i]+count-1)/count;
        }
        if(sum <= h){
            return count;
        }
    count++;

    }


    }
}
