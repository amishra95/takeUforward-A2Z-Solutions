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
// A rubbish question with poor analysis. How are they supposed to get ahead and solve corresponding solution and index case
class Solution {
    public long solve(int[] bt) {
        long sum = 0;
        long avg = 0;

        Arrays.sort(bt);
        
    for(int i = 0; i < bt.length; i++){
            sum += bt[i];
        }
        
         avg = sum/(bt.length);

     long wholeNumber = (long) Math.floor(avg);   
      return wholeNumber;

    }
}
