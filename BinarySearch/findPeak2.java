class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0; 
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Find the row index of the maximum element in the current 'mid' column
            int maxRow = maxElement(mat, mid);

            // Check left and right neighbors safely
            int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[maxRow][mid + 1] : -1;

            // If the current element is greater than both neighbors, it's a 2D peak
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[] {maxRow, mid};
            }
            // If the left neighbor is greater, move your search space to the left half
            else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            }
            // Otherwise, move to the right half
            else {
                low = mid + 1;
            }
        }

        return new int[] {-1, -1}; // Fallback (though a peak is guaranteed to exist)
    }

    private int maxElement(int[][] mat, int col) {
        int n = mat.length;
        int max = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }

        return index;
    }
}
