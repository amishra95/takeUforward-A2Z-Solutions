class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int originalColor = image[sr][sc];
       if(originalColor == newColor){
        return image;
       }
       dfs(sr, sc, image, newColor, originalColor);
       return image;

    }

    private void dfs(int row, int col, int[][] image, int newColor, int originalColor) {
        int n = image.length; 
        int m = image[0].length;
    
    image[row][col] = newColor;
    
    if(isValid(row-1, col, n, m)&& image[row-1][col] == originalColor){
           dfs(row-1, col, image, newColor, originalColor);
    }
    if(isValid(row+1, col, n, m)&& image[row+1][col] == originalColor){
        dfs(row+1, col, image, newColor, originalColor);
    }
    if(isValid(row, col-1, n, m)&& image[row][col-1] == originalColor){
        dfs(row, col-1, image, newColor, originalColor);
    }
    if(isValid(row, col+1, n, m)&& image[row][col+1] == originalColor){
           dfs(row, col+1, image, newColor, originalColor);    
    }

    }

    private boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }

}
