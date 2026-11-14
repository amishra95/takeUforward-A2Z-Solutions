// New and more understandable solution on 11/14/2026
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxValue(piles);
        int ans = high;
    
    while(low <= high){
    int mid = low+(high-low)/2;
    long hours = 0;
    for(int pile: piles){
        hours += (pile + mid -1)/mid; 

    }
    if(hours <= h){
        ans = mid;
        high = mid-1;

    }
    else{
        low = mid+1;
    }
        
    }

    return ans;
    }
   
    
    
    public int maxValue(int[] piles){
        int max = 0;
    for(int i = 0; i < piles.length; i++){
        if(piles[i] > max){
            max = piles[i];
        }
    }
    return max;

    }
}


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



    }
}
