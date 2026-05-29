class Solution {
    public int aggressiveCows(int[] nums, int k) {
        
        Arrays.sort(nums);
        int start = 1; 
        int end = nums[nums.length-1] - nums[0];

        while(start <= end){
            int mid = start + (end-start)/2;
                if(isPossible(nums, mid, k)){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
        }

    return end;
    }

    public boolean isPossible(int[] nums, int dist, int k){
        int cowsPlaced = 1;
        int lastPlaced = nums[0];

for(int i = 1; i < nums.length; i++){
    if((nums[i] - lastPlaced) >= dist){
        cowsPlaced++;
        lastPlaced = nums[i];
        if(cowsPlaced == k) return true;
    }
}
    return false;

    }
}
