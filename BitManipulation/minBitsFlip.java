class Solution {
    public int minBitsFlip(int start, int goal) {
    int num = start ^ goal;

    int count = 0;

    for(int i = 0; i < 32; i++){
        count += (num & 1);
        num = num >> 1;
    }
    
    return count;


    }
}
