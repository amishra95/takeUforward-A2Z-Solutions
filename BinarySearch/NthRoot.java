class Solution {
    public int NthRoot(int N, int M) {
       for(int i = 1; i <= M; i++){
        long val = power(i, N);

        if(val == M){
            return i;
        }
        else if( val > M){
            break;
        }
       }
       return -1;
        
    }

    public long power(int a , int exp){
        long ans = 1; 
        long base = a;

        while(exp > 0){
            if(exp % 2 == 1){
                exp--;
                ans *= base;
            }
            else{
                exp /= 2;
                base *= base;
            }
        }
        return ans;
    }
}
