class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean backtrack(char[][] board, String word, int i, int j, int k){
        if(k == word.length()){
            return true;
       }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = backtrack(board, word, i+1, j, k+1)||backtrack(board, word, i-1, j, k+1) || backtrack(board, word, i, j+1, k+1) || backtrack(board, word, i, j-1, k+1);

        board[i][j] = temp;

        return found;



    }
}
