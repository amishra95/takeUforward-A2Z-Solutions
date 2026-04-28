class Solution {
    public int roseGarden(int n, int[] nums, int k, int m) {
        if(n < (long) m * k){
            return -1;
        }

        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            lo = Math.min(lo, nums[i]);
            hi = Math.max(hi, nums[i]);
        }

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            if(countBouquets(nums, mid, k) >= m){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int countBouquets(int[] nums, int day, int k){
        int bouquets = 0;
        int consecutive = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= day){
                consecutive++;
                if(consecutive == k){
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }

        return bouquets;
    }
}
