//Solution 1: Passes 122/132 tests
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                long count = (mid - left) * (right - mid);
                sum += arr[mid] * count;
            }
            stack.push(i);
        }
        
        // Process remaining elements in stack
        while (!stack.isEmpty()) {
            int mid = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();  // Check AFTER popping
            int right = arr.length;
            long count = (long)(mid - left) * (right - mid);  // Cast to long to prevent overflow
            sum += (long)arr[mid] * count;  // Cast to prevent overflow
        }
        
        return (int) sum;
    }
}


class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9 + 7;
        
        // Get the index of previous smaller and next smaller elements
        int[] prevSmaller = prevSmallestElemnt(arr);
        int[] nextSmaller = nextSmallestElement(arr);
        
        long ans = 0;
        
        // Calculate contribution of each element
        for (int i = 0; i < n; i++) {
            // Calculate how many positions left we can extend
            int left = i - prevSmaller[i];  // distance to previous smaller
            
            // Calculate how many positions right we can extend
            int right = nextSmaller[i] - i;  // distance to next smaller
            
            // Number of subarrays where arr[i] is minimum = left * right
            // Contribution = arr[i] * left * right
            long contribution = (long) arr[i] * left * right;
            
            ans = (ans + contribution) % MOD;
        }
        
        return (int) ans;
    }

    private int[] nextSmallestElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            int currEle = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }
    
        return ans;
    }

    private int[] prevSmallestElemnt(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int currEle = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return ans;
    }
}





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
