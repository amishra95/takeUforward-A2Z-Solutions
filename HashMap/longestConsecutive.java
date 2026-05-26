class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int longest = 0;

        for(int a:set){
            if(!set.contains(a-1)){
                int current = 1;
                while(set.contains(a + current)){
                    current++;
                }
         longest = Math.max(longest, current);

            }
        }
        return longest;
    }
}

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
