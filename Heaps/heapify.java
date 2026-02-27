class Solution {
    public void heapify(int[] nums, int ind, int val) {
        
        int oldVal = nums[ind];
        nums[ind] = val;

        if(val < oldVal){
            shiftUp(nums, ind);
        }
        else{
            shiftDown(nums, ind);
        }

    }

    public void shiftUp(int[] nums, int i){
        while(i > 0){
            int parent = (i-1)/2;
            if(nums[i] < nums[parent]){
                swap(nums, i, parent);
                i = parent;
            }
            else{
                break;
            }
        }

    }

    public void shiftDown(int[] nums, int i){
        int n = nums.length; 
        while(i < n){
            int smallest = i;
            int left = 2*i + 1;
            int right = 2*i+2;

            if(left < n && nums[left] < nums[smallest]){
                smallest = left;
            }
            if(right < n && nums[right] < nums[smallest]){
                smallest = right;
            }
            if(smallest != i){
                swap(nums, i, smallest);
                i = smallest;
            } else{
                break;
            }
        }
    }
    
    
    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    
    }

    
}
