class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        backtrack(mat, 0, 0, n, "", visited, result);
        return result;
    }

    public void backtrack(int[][] mat, int row, int col, int n, String path, boolean[][] visited, ArrayList<String> result) {
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // directions: Down, Left, Right, Up
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (isValid(mat, newRow, newCol, n, visited)) {
                backtrack(mat, newRow, newCol, n, path + dir[i], visited, result);
            }
        }

        visited[row][col] = false; // backtrack
    }

    public boolean isValid(int[][] mat, int row, int col, int n, boolean[][] visited) {
        return row >= 0 && row < n && col >= 0 && col < n
                && mat[row][col] == 1 && !visited[row][col];
    }
}
