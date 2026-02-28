class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        for(int i = n/2-1; i >=0; i--){
            heapifyDown(nums, i);
        }
        return nums;
    }
    private void heapifyDown(int[] arr, int i){
        int n = arr.length;
       
        int large = i;
        int left = 2*i+1;
        int right = 2*i+2;
    
    if(left< n && arr[left] > arr[large]){
        large = left;
    }
    if(right < n && arr[right] > arr[large]){
        large = right;
    }

    if(large != i){
        int temp = arr[large];
        arr[large] = arr[i];
        arr[i] = temp;

        heapifyDown(arr, large);
    }


    }   
}
