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
