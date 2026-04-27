class Solution {
    public int stockBuySell(int[] arr, int n) {
        int sell1 = 0;
        int sell2 = 0;
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        for(int a: arr){
            
            buy1 = Math.max(buy1, -a);
            sell1 = Math.max(sell1, buy1+a);
            buy2 = Math.max(buy2, sell1-a);
            sell2 = Math.max(sell2, buy2+a);

        }

        return sell2;
     
    }
}

