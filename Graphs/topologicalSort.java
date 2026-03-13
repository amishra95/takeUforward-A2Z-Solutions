class Solution {
  public int[] topoSort(int V, List<List<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, stack, adj);
      }
    }
    int[] result = new int[V];
    for (int i = 0; i < V; i++) {
      result[i] = stack.pop();
    }

    return result;
  }

  public void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {

    visited[node] = true;

    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, visited, stack, adj);
      }
    }
    stack.push(node);
  }
}
