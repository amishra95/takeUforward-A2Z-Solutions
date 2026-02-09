//Tried the Monotonic Stack case

class Solution {
    public int[] nextLargerElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] a = new int[arr.length];

    for(int i = arr.length-1; i >= 0; i--){
        while(!stack.isEmpty() && stack.peek() <= arr[i]){
            stack.pop();
        }
    
        if(stack.isEmpty()){
            a[i] = -1;
        }
        else
            a[i] = stack.peek();
            stack.push(arr[i]);

    }
    
    return a;
    }
}

// Improper Solution and not the defined result value. (Need to use Stack)
class Solution {
    public int[] nextLargerElement(int[] arr) {

        int[] proArray = new int[arr.length];

    for(int i = 0; i < arr.length; i++){
        proArray[i] = -1;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] > arr[i]){
                proArray[i] = arr[j];
                break;
            }

        }
    }
    return proArray;
    
    }
}
