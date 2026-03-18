class Solution {
    public int MinimumEffort(List<List<Integer>> heights) {
    int n = heights.size();
    int m = heights.get(0).size();
    return dijkstra(heights, n, m);
}

    
    public int dijkstra(List<List<Integer>> heights, int n, int m)
    {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dist = new int[n][m];
        
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
       
       int[] delRow = {-1, 1, 0, 0};
       int[] delCol = {0, 0, -1, 1};

       while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];
            if (effort > dist[row][col]) continue;
            if (row == n-1 && col == m-1) return effort;

        for(int i = 0; i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
    if (isValid(newRow, newCol, n, m)) {
            int newEffort = Math.max(effort, 
                Math.abs(heights.get(row).get(col) - 
                         heights.get(newRow).get(newCol)));
            
            if (newEffort < dist[newRow][newCol]) {
                dist[newRow][newCol] = newEffort;
                pq.add(new int[]{newEffort, newRow, newCol});
            }
        }
    }
}
return Integer.MAX_VALUE;
    }
     public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        return true;
    }


}
