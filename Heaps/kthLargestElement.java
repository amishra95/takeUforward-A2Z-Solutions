// Use of Min-Heap as a model to solve the question
class Solution {
    public int kthLargestElement(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int num: nums){
            queue.offer(num);
            if(queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }
}

// Solved it using Arrays Sort. 
class Solution {
    public int kthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);

    for(int i = nums.length; i >0; i--){
        return nums[nums.length-k];
        
    }

    return 0;

    }
}
