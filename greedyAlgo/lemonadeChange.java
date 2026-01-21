class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
      

    for(int i = 0; i < bills.length; i++){
        if(bills[i] == 5){
            countFive++;
        }
        else if(bills[i] == 10){
            if(countFive == 0){
                return false;
            }
            countFive--;
            countTen++;
        }
        else {
            if(countTen > 0 && countFive > 0){
                countTen--;
                countFive--;
            }
            else if(countFive  >= 3){
                countFive -=3;
            }
            else {
                return false;
            }
        }
    }
        return true;



    }
}
