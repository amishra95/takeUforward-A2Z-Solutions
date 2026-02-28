class Solution {
    private List<Integer> arr; // list to store the min-heap
    private int count; // to store the count of elements in min-heap
    
    // Constructor
    public Solution() {
        arr = new ArrayList<>();
        count = 0;
    }
    
    // Function to recursively heapify the array upwards
    private void heapifyUp(List<Integer> arr, int ind) {
        int parentInd = (ind - 1)/2; 

        // If current index holds smaller value than the parent
        if(ind > 0 && arr.get(ind) < arr.get(parentInd)) {
            // Swap the values at the two indices
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);

            // Recursively heapify the upper nodes
            heapifyUp(arr, parentInd);
        } 

        return;
    }
    
    // Function to recursively heapify the array downwards
    private void heapifyDown(List<Integer> arr, int ind) {
        int n = arr.size(); // Size of the array

        // To store the index of smallest element
        int smallestInd = ind; 

        // Indices of the left and right children
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;
        
        // If the left child holds smaller value, update the smallest index
        if(leftChildInd < n && arr.get(leftChildInd) < arr.get(smallestInd)) 
            smallestInd = leftChildInd;

        // If the right child holds smaller value, update the smallest index
        if(rightChildInd < n && arr.get(rightChildInd) < arr.get(smallestInd)) 
            smallestInd = rightChildInd;

        // If the smallest element index is updated
        if(smallestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr.get(smallestInd);
            arr.set(smallestInd, arr.get(ind));
            arr.set(ind, temp);

            // Recursively heapify the lower subtree
            heapifyDown(arr, smallestInd);
        }

        return; 
    }
    
    // Method to intialize the min-heap data structure
    public void initializeHeap(){
        arr.clear();
        count = 0;
    }
    
    // Method to insert a given value in the min-heap
    public void insert(int key){
        // Insert the value at the back of the list 
        arr.add(key);
        
        // Heapify upwards
        heapifyUp(arr, count);
        count = count+1; // Increment the counter;
        
        return;
    }
        
    // Method to change the value at a given index in min-heap
    public void changeKey(int index, int new_val){
        // If the current value is replaced with a smaller value
        if(arr.get(index) > new_val) {
            arr.set(index, new_val);
            heapifyUp(arr, index);
        }
        // Else if the current value is replaced with a larger value
        else {
            arr.set(index, new_val);
            heapifyDown(arr, index);
        }

        return;
    }
    
    // Method to extract the minimum value from the min-heap
    public void extractMin(){
        int ele = arr.get(0); // minimum value in the heap
        
        // Swap the top value with the value at last index
        int temp = arr.get(count - 1);
        arr.set(count - 1, arr.get(0));
        arr.set(0, temp);
        
        arr.remove(count - 1); // Pop the minimum value from the list
        count = count - 1; // Decrement the counter
        
        // Heapify the root value downwards
        if(count > 0) {
            heapifyDown(arr, 0);
        }
    }
    
    // Method to return if the min-heap is empty
    public boolean isEmpty(){
        return (count == 0);
    }
    
    // Method to return the minimum value in the min-heap
    public int getMin(){
        // Returning the value stored at the root
        return arr.get(0);
    }
    
    // Method to return the size of min-heap
    public int heapSize(){
        return count;
    }
}
