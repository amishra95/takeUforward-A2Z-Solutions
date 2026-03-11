class Solution {
  public boolean isBipartite(int V, List<List<Integer>> adj) {
    int[] visited = new int[V];
    Arrays.fill(visited, -1);

    for (int i = 0; i < V; i++) {
      if (visited[i] == -1) {
        if (bfs(i, visited, adj)) return false;
      }
    }
    return true;
  }

  private boolean bfs(int i, int[] visited, List<List<Integer>> adj) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, 0});
    visited[i] = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int color = current[1];

      for (int neighbor : adj.get(node)) {
        if (visited[neighbor] == -1) {
          visited[neighbor] = 1 - color;
          queue.add(new int[]{neighbor, 1 - color});
        } else if (visited[neighbor] == color) {
          return true;
        }
      }
    }
    return false;
  }
}
