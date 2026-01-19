//Naive method to solve
class Solution {
    public int findRangeXOR(int l, int r) {
        int solve = 0;
        for(int i = l; i <= r; i++){
            solve ^= i;
        }   
    
        return solve;
    }
}
// Faster and O(1) method
class Solution {
    public int findRangeXOR(int l, int r) {

        return XORend(l-1) ^ XORend(r);
    }

    private int XORend(int n){
        if(n % 4 == 1) return 1;
        if(n% 4 == 2) return n+1;
        if(n % 4 == 3) return 0;
        return n;
    }
}
