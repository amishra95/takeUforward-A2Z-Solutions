
class MinStack {
    private Stack<Integer> stack;
    private int mini;
   
    public MinStack() {
        stack = new Stack<>();
        
    }

    public void push(int val) {
       ////If Stack is Empty
        if(stack.isEmpty()){
            //Update the minimum value
            mini = value;
            //Push current value as minimum
            stack.push(value);
            return;
        }

        //If the value is greater than the minimum
        if(value > mini){
            stack.push(val)
        }
        else {
            stack.push(2*value-mini);
            mini = value;
        }
   
    }

    public void pop() {
        if(stack.isEmpty()) 
        return;

        int x = stack.pop();

        if(x < mini){
            mini = 2*mini -x;
        }
    }

    public int top() {

        if(stack.isEmpty()) return -1;
        
        int x = stack.peek();
        
        if(mini < x) return x;
        return mini;
    
    }

    public int getMin() {
        return mini;
    }
}
```
