class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
       int prefixSum = 0;
       int longestSubarray = 0;

       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
    
    for(int i = 0; i < nums.length; i++){
        prefixSum += nums[i];
        
        if(prefixSum == k){
            longestSubarray = i+1;
        }
        if (map.containsKey(prefixSum - k)) {
            longestSubarray = Math.max(longestSubarray, i - map.get(prefixSum - k));
        }
        if (!map.containsKey(prefixSum)) {
            map.put(prefixSum, i);
}
    }
     return longestSubarray;

    }
}
