class Solution {
    public long solve(int[] bt) {
        long waitTime = 0;
        long totalTime = 0;
    
        Arrays.sort(bt);

        for(int i = 0; i < bt.length; i++){
            waitTime += totalTime;
            totalTime += bt[i];
        }
    
        return waitTime/bt.length;
    }
}
