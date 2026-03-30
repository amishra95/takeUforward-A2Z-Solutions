class Solution {
    public int stockBuySell(int[] arr, int n) {
    int max = 0;
    int min = arr[0];

    for(int i = 0; i < n; i++){
        if(arr[i] < min){
            min = arr[i];
        }

    int profit = arr[i] - min;

    if(profit > max){
        max = profit;
    }

    }
       return max;
    }
}
