import java.util.HashMap;
class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;

    for(int i =0; i < nums.length; i++){
        sum += nums[i];
    
        if(sum == k){
            length = i+1;
        }
        if(map.containsKey(sum-k)){
           length = Math.max(length,i - map.get(sum - k));
        }
        if(!map.containsKey(sum)){
            map.put(sum, i);
        }
    }
       return length;
    }
}
