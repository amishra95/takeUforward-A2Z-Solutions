class Solution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {

        boolean[] visited = new boolean[N];

        boolean[] pathVisited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                if(dfs(i,visited, pathVisited, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {

     visited[node] = true;
pathVisited[node] = true;

for (int neighbor : adj.get(node)) {
    if (!visited[neighbor]) {
        if (dfs(neighbor, visited, pathVisited, adj)) 
        return true;
    } 
    else if (pathVisited[neighbor]) return true;
}

pathVisited[node] = false;
    return false;

    }

}
