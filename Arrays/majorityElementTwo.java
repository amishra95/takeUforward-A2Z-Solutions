class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        
        int n = nums.length;
        int count = 1;
        int defCount = n/3;

        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
    
    for(int i = 1; i < n; i++){
        if(nums[i-1] == nums[i]){
            count++;
        }

        else{
            if(count > defCount){
              list.add(nums[i-1]);
        }
            count = 1;

    }
          

    }
        if(count > defCount){
        list.add(nums[n-1]);
    }

        return list;
    }

}
