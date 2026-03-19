class Solution {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
      
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{0, src, 0});
    
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] flight: flights){
            adj[flight[0]].add(new int[]{flight[1],flight[2]});
        }
        while (!queue.isEmpty()) {
    int[] curr = queue.poll();
    int stops = curr[0];
    int node = curr[1];
    int cost = curr[2];
    
    if (stops > K) continue;
    for (int[] it : adj[node]) {
    int nextNode = it[0];
    int price = it[1];
    
    if (cost + price < dist[nextNode]) {
        dist[nextNode] = cost + price;
        queue.add(new int[]{stops + 1, nextNode, cost + price});
    }
}

}

    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];


    }
    
}

