class Solution {
    public int maxScore(int[] cardScore, int k) {
        
        int leftSum = 0;
        int rightSum = 0;
        int sum  = 0;

        for(int i = 0; i < k; i++){
            leftSum += cardScore[i];
            sum = leftSum;
        }
        int rightIndex = cardScore.length-1;

        for(int i= k-1; i>= 0; i--){
            leftSum -= cardScore[i];
            rightSum += cardScore[rightIndex];
            rightIndex--;
        
        sum = Math.max(sum, leftSum + rightSum);
        }
        return sum;

    }
}
