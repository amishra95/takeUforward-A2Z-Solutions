class Solution {
    public int largestSubarraySumMinimized(int[] a, int k) {
        int start = 0;
        int end = a.length; 
        int sum = 0;
        

        for(int i = 0; i < a.length; i++){
           start = Math.max(start, a[i]);
           end += a[i]; 
           
        }
            int result = end;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(partition(a, k, mid)){
                result = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            
 
        }

    return result;
       
    }

    public boolean partition(int[] a, int k, int mid){
        int subarrays = 1;
        int currentSum = 0;

        for(int i = 0; i < a.length; i++){
            if(currentSum + a[i] > mid){
                subarrays++;
                currentSum = a[i];
                if(subarrays > k) return false;
            }
            else{
                currentSum += a[i];
            }
        }
        return true;
    }
}
