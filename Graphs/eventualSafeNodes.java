class Solution {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] safe = new boolean[V];

        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, pathVisited,safe, adj);
                }
            }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(safe[i]){
                list.add(i);
            }
        }
       
           return list.stream().mapToInt(Integer::intValue).toArray();

        }
       
    

  
  public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, boolean[] safe, int[][] adj) {
    visited[node] = true;
    pathVisited[node] = true;

    for (int neighbor : adj[node]) {
        if (!visited[neighbor]) {
            if (dfs(neighbor, visited, pathVisited,safe, adj)) return true;
        } else if (pathVisited[neighbor]) return true;
    }

    pathVisited[node] = false;  
    safe[node] = true;
    return false;               
}
    
}
