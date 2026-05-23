class Solution {
    public long numberOfInversions(int[] nums) {
      int n = nums.length;

      return mergeSort(nums, 0, n-1);
    }

    
   private long merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
      
        int left = low;
        int right = mid+1;
        int index = 0;

        long count = 0;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }
            else{
                temp[index++] = arr[right++];
                count += (mid-left+1);
            }
        }
        
        while(left <= mid){
            temp[index++] = arr[left++];
        }
        while(right <= high){
            temp[index++] = arr[right++];
        }
   
    System.arraycopy(temp, 0, arr, low, high-low+1);
   
    return count;

   }
   
   
    private long mergeSort(int[] arr, int low, int high){
        long count = 0; 
        if(low < high){
            int mid = low + (high-low)/2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid+1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }
}
