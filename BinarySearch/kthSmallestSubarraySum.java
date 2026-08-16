class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
     
     int low = 0;
     int high = (int) 1e9;
     int result = high;

    while(low <= high){
     int mid = low+(high - low)/2;
     
     int count = smallestSum(nums, mid);
     if(count >= k){
       result = mid;
       high = mid-1;
     }
     else{
        low = mid+1;
     }


     }


return result;


    }

   
    public int smallestSum(int[] array, int target){
    
    int left = 0;
    int sum = 0;
    int count = 0;

    for(int right = 0; right < array.length; right++){
        sum += array[right];
        
        while(sum > target){
            sum -= array[left];
            left++;
        }
        count += right-left+1;
    }

    return count;

    }
}

// This solution gives a TLE
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
