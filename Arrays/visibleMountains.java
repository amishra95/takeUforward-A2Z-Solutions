class Solution {
    public int visibleMountains(int[][] peaks) {

        int n = peaks.length;
        int[][] intervals = new int[n][2];
        int count = 0;
        int maxR = Integer.MIN_VALUE;

    for(int i = 0; i < peaks.length; i++){
        int x = peaks[i][0] + peaks[i][1];
        int y = peaks[i][0] - peaks[i][1];
        intervals[i][0] = y;
        intervals[i][1] = x;
    }
    
    Arrays.sort(intervals, (a,b) ->{
        if(a[0] != b[0]){
            return a[0] - b[0];
        }
        else
        return b[1]-a[1];
    });
    
    HashMap<Long, Integer> map = new HashMap<>();

    for(int[] interval : intervals){
            long key = encode(interval[0], interval[1]);
            map.merge(key, 1, Integer::sum);

    }
        
    for(int[] interval: intervals){
      int L = interval[0];
       int R = interval[1];
       long key = encode(L, R);

       boolean isDuplicate = map.get(key) > 1;
        if(R <= maxR || isDuplicate){
            continue;
        }
        else{
            count++;
        }
        
    maxR = Math.max(R, maxR);
    }


    
    return count;
    }

    private long encode(long L, long R) {
    long OFFSET = 200000;
    return (L + OFFSET) * 1000000L + (R + OFFSET);

}
}
