class Solution {
    public int maxMeetings(int[] start, int[] end) {
       int n = start.length;
       int m = end.length; 
// Creating the key value of the arrays 

    int[][] array= new int[n][2] ;

 //Find key index value which has both start and end in it.
    for(int i = 0; i < n; i++){
        array[i][0] = start[i];
        array[i][1] = end[i];
    }
    
    Arrays.sort(array, (a,b) -> a[1]- b[1]);

    int count = 1;
    int endTime = array[0][1];

    for(int i = 1; i < n; i++){
        if(array[i][0] > endTime){
            count++;
            endTime = array[i][1];
        }

    }
        return count;
        //Once you add the array in this zone then you solve them
    }
}
