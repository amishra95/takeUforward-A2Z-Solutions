class Solution {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int lo = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while(lo < high){
            int mid = lo +(high-lo)/2;
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += (nums[i]+mid-1)/mid;
            }
            if(sum <= h){
                high = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}

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
