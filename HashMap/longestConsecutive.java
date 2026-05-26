// Use of Sorting not Hash Map
class Solution {
    public int longestConsecutive(int[] nums) {
    
    Arrays.sort(nums);
    int count = 1;
    int longest = 1;

    for(int i = 0; i < nums.length-1; i++){
      if(nums[i] + 1 == nums[i+1]){
            count++;
      }
      else{
        longest = Math.max(count, longest);
        count = 1;

      }
        
    }
        return Math.max(count, longest);
    }
}
