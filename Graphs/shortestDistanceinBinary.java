class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {

          int result = bfs(grid, source, destination);
          if(result == Integer.MAX_VALUE){
                return -1;
          }

          return result;


    }
    public int bfs(int[][] grid, int[] source, int[] destination)
 {

        int n = grid.length;
        int m = grid[0].length;

      Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{source[0], source[1]});
        int[][] dist = new int[n][m];
        
        for (int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]] = 0;
    
    while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
        if (row == destination[0] && col == destination[1]) 
            return dist[row][col];
            
            int[] delRow = {-1, 1, 0, 0};
            int[] delCol = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
        
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
    && grid[newRow][newCol] == 1 
    && dist[row][col] + 1 < dist[newRow][newCol]) {
    dist[newRow][newCol] = dist[row][col] + 1;
    queue.add(new int[]{newRow, newCol});
    }
}


}
return -1;
 }
}
