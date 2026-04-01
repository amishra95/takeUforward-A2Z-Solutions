// The use of surcharge/fees when selling
class Solution {
    public int stockBuySell(int[] arr, int n, int fee) {
        int hold = -arr[0];
        int cash = 0;

        for(int i = 1; i < n; i++){
           int prevHold = hold;
           int prevCash = cash;

           hold = Math.max(prevHold, prevCash - arr[i]);
           cash = Math.max(prevCash, prevHold+arr[i]-fee);
        }

        return cash;
    }
}
