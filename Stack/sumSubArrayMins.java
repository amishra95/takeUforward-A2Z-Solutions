





// TLE; so Poor code which needs improvement, trying Monotonic Stack method right now
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        
        int mod = (int)1e9 + 7;
    
// Find the subarray Minimums and solution base involved in them?

    for(int i = 0; i < arr.length; i++){
       int mini = arr[i];

    for(int j = i; j < arr.length; j++){
        mini = Math.min(mini,  arr[j]);
        sum = (sum + mini) % mod;

    }

    }


    return (int) sum;

    }
}
