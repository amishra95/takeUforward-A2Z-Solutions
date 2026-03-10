//Solved using BFS
class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        
        boolean[] visited = new boolean[V];

        boolean ans = false;

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                ans = bfs(i, adj, visited);
                if (ans) break;
            }
        }
            return ans;
    }

    private boolean bfs(int i, List<Integer>[] a, boolean[] visited){
       Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, -1});
        visited[i] = true;
        

        while(!q.isEmpty()){
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];

            for(int it:a[node]){
                if(!visited[it]){
                    visited[it] = true;
                   q.add(new int[]{it, node});
                }
                else if(it != parent) return true;
            }
        }

        return false;
    }
}
