class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        
        int count = 0;
        int max = 0;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        
        int i = 0, j = 0;

        while(i <= Arrival.length-1 &&  j <= Departure.length-1){
            if(Arrival[i] <= Departure[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;

            }

        max = Math.max(count, max);
        }
        return max;
    }
}
