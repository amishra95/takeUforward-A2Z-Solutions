class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        int[] a = new int[n];

for(int i = 2* n-1; i >= 0; i--){
        int currentNum = arr[i % n];

        while(!stack.isEmpty() && stack.peek() <= currentNum){
            stack.pop();
        }
        if(i < n){
        if(stack.isEmpty()){
            a[i] = -1;
        }
        else{
            a[i] = stack.peek();
        }
    }
    stack.push(currentNum);

    }
    return a;
    
        
   
    }
}
