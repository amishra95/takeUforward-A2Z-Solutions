class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i-1][1] > intervals[i][0]){
                return false;
            }
        }

    return true;

       
    }
}


class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
          
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(intervals[i][1] > intervals[j][0] && intervals[i][0] < intervals[j][1]){
                    return false;
                }
            }
        }
        return true;
       
    }
}
