public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>(); 
        boolean[] visited = new boolean[V];

        dfs(0, adj, visited, list); 
      
      return list;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> list){
        visited[node] = true;
        list.add(node);

        for(int neighbor :adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, visited, list);
            }
        }
    }
