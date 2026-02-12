class Solution {
    public int[] stockSpan(int[] arr, int n) {

       //Result array tp stpre the span for each day 
        int[] b = new int[n];
        //Stack stores pairs: {index, price}
        Stack<int[]> stack = new Stack<>();
    
    for(int i = 0; i < arr.length; i++){

        //Pop all elemnets with price lower than current price
        while(!stack.isEmpty() && stack.peek()[1] <= arr[i]){
            stack.pop();
         }
        
        //Calculate span for the day
        if(stack.isEmpty()){
            // If stack is empty, all previous days had price <= current
                // So span = all days from 0 to i (inclusive)

            b[i] = i+1;
        }
        else{
             // Stack top has the last day with price > current price
                // Span = distance from that day to current day
            b[i] = i- stack.peek()[0];
        }

                    // Push current day's {index, price} onto stack
            // Future days will use this to calculate their span

        stack.push(new int[]{i, arr[i]});

    }
     return b;
    }
}

