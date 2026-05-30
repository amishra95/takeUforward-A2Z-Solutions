class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double start = 0;
        double end = arr[n-1]- arr[0];

        while(end - start >= 1e-7){
        double mid = start + (end-start)/2;
        if(canAchieve(mid, arr, k)){
            end = mid;
        }
        else{
            start = mid;
        }
    }
        return start;
    }

    private boolean canAchieve(double maxDist, int[] arr, int k){
        int reqStation = 0;

    for(int i = 0; i < arr.length-1; i++){
        double distance = arr[i+1]-arr[i];
        reqStation += (int) (distance/maxDist);
    }

    return reqStation <= k;


    }
}
