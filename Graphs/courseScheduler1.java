```java
class Solution {
    public boolean canFinish(int N, int[][] arr) {
       
        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

       
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        for(int[] pre: arr){
            list.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < N; i++) {
    if (!visited[i]) {
        if (dfs(i, visited, pathVisited, list)) return false;
    }
}
return true;

                
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
```
