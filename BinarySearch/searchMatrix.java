//Fastest solution O(Log(n*m))
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

    int left = 0;
    int right = n*m-1;

    while(left <= right){
        int mid = left + (right-left)/2;
        int row = mid/m;
        int col = mid%m;

        if(mat[row][col]== target){
            return true;
        }
        else if(mat[row][col] < target){
            left = mid+1;

        }
        else{

        right = mid-1;
        }

}
    return false;
}
    
}

//Worst Solution
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;

    }
}
