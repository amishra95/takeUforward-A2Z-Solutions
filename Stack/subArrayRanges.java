class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] nextGreater = nextGreatElement(nums);
        int[] prevGreater = prevGreatElement(nums);
        int[] nextSmaller = nextSmallerElement(nums);
        int[] prevSmaller = prevSmallerElement(nums);

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            long maxContrib = (long)(i - prevGreater[i]) * (nextGreater[i] - i);
            long minContrib = (long)(i - prevSmaller[i]) * (nextSmaller[i] - i);
            totalSum += (maxContrib - minContrib) * nums[i];
        }

        return totalSum;
    }

    public int[] nextGreatElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] mess = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            mess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return mess;
    }

    public int[] prevGreatElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] mess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            mess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return mess;
    }

    public int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] mess = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            mess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return mess;
    }

    public int[] prevSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] mess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            mess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return mess;
    }
}
