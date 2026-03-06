class Solution {

  // undirected graph
  public int numProvinces(int[][] adj) {

    boolean[] visited = new boolean[adj.length];
    int count = 0;
    for (int i = 0; i < adj.length; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited);
        count++;
      }
    }
    return count;
  }

  private void dfs(int node, int[][] adj, boolean[] visited) {
    visited[node] = true;

    for (int j = 0; j < adj[node].length; j++) {
      if (adj[node][j] == 1 && !visited[j]) {
        dfs(j, adj, visited);
      }
    }
  }
}
