class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
    
    int[] dist = new int[V];
    Arrays.fill(dist, (int) 1e9);

    dist[S] = 0;
    
    for (int i = 0; i < V-1; i++) {
        for(ArrayList<Integer> k: edges){
            int u = k.get(0);
            int v = k.get(1);
            int weight = k.get(2);

            if(dist[u] != 1e9 && dist[u] + weight < dist[v]){
                dist[v] = dist[u] + weight;
            }
        }

    }
// checking for negative values in the loop
    for(ArrayList<Integer> k: edges){
            int u = k.get(0);
            int v = k.get(1);
            int weight = k.get(2);

            if(dist[u] != 1e9 && dist[u] + weight < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;

    
    }
}
