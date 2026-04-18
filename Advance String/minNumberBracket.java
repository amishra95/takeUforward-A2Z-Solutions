class Solution {
    public int countRev(String s) {

        int n = s.length();

        if(n %2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(c);   
            }
        }

        int open = 0;
        int close = 0;

        while(!stack.isEmpty()){
            if(stack.pop() == '('){
                open++;
            }
            else
            close++;
        }
             return (int) (Math.ceil(close / 2.0) + Math.ceil(open / 2.0));

    }
}
