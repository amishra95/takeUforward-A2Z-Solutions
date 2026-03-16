class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

       pq.add(new int[]{0, S});
       while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if (d > dist[node]) continue;

         for (ArrayList<Integer> it : adj.get(node)) {
            int nextNode = it.get(0);
            int edgeWeight = it.get(1);

            if (d + edgeWeight < dist[nextNode]) {
    dist[nextNode] = d + edgeWeight;
    pq.add(new int[]{dist[nextNode], nextNode});
}

    }
}
for (int i = 0; i < V; i++) {
    if (dist[i] == Integer.MAX_VALUE) dist[i] = 1000000000;
}

        return dist;

    }
}
