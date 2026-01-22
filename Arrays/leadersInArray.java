class Solution {
    public List<Integer> leaders(int[] nums) {

        List<Integer> list = new ArrayList<>();

        if(nums.length == 0){
            return list;
        }

        int max = nums[nums.length-1];
        list.add(nums[nums.length-1]);

        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] > max){
                list.add(nums[i]);
                max = nums[i];
            }
        }
        
        Collections.reverse(list);
        return list;
    }
}
