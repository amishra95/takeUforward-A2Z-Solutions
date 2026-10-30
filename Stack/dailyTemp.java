class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] array = new int[n];

        Stack<Integer> stack = new Stack<>();
       
    for(int i = 0; i < n; i++){
     while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
        array[stack.peek()] = i - stack.pop();
     }
     stack.push(i);

        }

        return array;
    }
}
