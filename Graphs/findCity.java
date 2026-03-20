class Solution {

    public int findCity(int n, int m, int edges[][],
                 int distanceThreshold) {
   
        int[][] dist = new int[n][n];

        for (int[] row : dist) Arrays.fill(row, (int)1e9);
        for (int i = 0; i < n; i++) dist[i][i] = 0;

   for (int[] edge : edges) {
    dist[edge[0]][edge[1]] = edge[2];
    dist[edge[1]][edge[0]] = edge[2]; // bidirectional!
}

    for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
                if (dist[i][k] != (int)1e9 && dist[k][j] != (int)1e9) {
    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
}

    
            }
    }
}
int minCount = Integer.MAX_VALUE;
int result = -1;

for (int i = 0; i < n; i++) {
    int count = 0;
    for (int j = 0; j < n; j++) {
        if (i != j && dist[i][j] <= distanceThreshold) {
            count++;
        }
    }
    // if tie → pick greater city number
    if (count <= minCount) {
        minCount = count;
        result = i;
    }
}
return result;


    
    }
}

