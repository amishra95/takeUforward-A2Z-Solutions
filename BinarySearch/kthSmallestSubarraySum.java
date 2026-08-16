class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i; j < nums.length; j++){
                count += nums[j];
                list.add(count);
            }
        }

        Collections.sort(list);

        return list.get(k-1);


    }
}
