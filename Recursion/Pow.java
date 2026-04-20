class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if(num < 0){
            return (1.0/recursion(x, -num));
        }
        return recursion(x, num);
    }

    public double recursion(double x, long n){
        if(n == 0) return 1.0;
        
        if(n ==1) return x;

        if(n %2 == 0){
            return recursion(x*x, n/2);

        }
        return x *recursion(x, n-1);

        
    }
}
