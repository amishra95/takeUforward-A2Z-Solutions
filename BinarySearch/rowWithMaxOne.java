class Solution {
    public int rowWithMax1s(int[][] mat) {

        int count = 0;
        int max = 0;
        int maxRow = -1;

        for(int i = 0; i < mat.length; i++){
            count = 0;                   
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }

                if(count > max){
                    max = count;
                    maxRow = i;
                }
            }
                                          
        }
        return maxRow;                    
    }
}
