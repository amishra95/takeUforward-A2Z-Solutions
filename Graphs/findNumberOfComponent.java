class Solution {
public int findNumberOfComponent(int V, List<List<Integer>> edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    
    for (List<Integer> edge : edges) {
        adj.get(edge.get(0)).add(edge.get(1));
        adj.get(edge.get(1)).add(edge.get(0));
    }
    
    boolean[] visited = new boolean[V];
    int components = 0;
    
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            bfs(i, adj, visited);
            components++;
        }
    }
    return components;
}

private void bfs(int src, List<List<Integer>> adj, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(src);
    visited[src] = true;
    while (!q.isEmpty()) {
        int node = q.poll();
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                q.offer(neighbor);
            }
        }
    }
}
} 
