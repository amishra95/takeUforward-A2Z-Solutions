class Solution {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;

    for(int i = n/2-1; i>=0; i--){
            heapifyDown(nums, i, n);
    }
    
    }

    public void heapifyDown(int[] nums, int i, int n){
       int smallest = i;
       int leftNode = 2*i+1;
       int rightNode = 2*i+2;

       if(leftNode < n && nums[leftNode] < nums[smallest]){
            smallest = leftNode;
       }

       if(rightNode <  n && nums[rightNode] <  nums[smallest]){
            smallest = rightNode;
       }
        
        if(smallest != i){
            swap(nums, i, smallest);
            heapifyDown(nums, smallest , n);

        }
    
    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }

    
}
