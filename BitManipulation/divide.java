class Solution {
    public int divide(int dividend, int divisor) {
        // Handle division by zero
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Handle signs
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Work with absolute values (use long to avoid overflow)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        long sum = 0;
        int count = 0;
        
        while (sum + absDivisor <= absDividend) {
            count++;
            sum += absDivisor;
        }
        
        return isNegative ? -count : count;
    }
}
