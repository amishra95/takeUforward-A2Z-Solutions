class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {

List<int[]>[] adj = new ArrayList[n+1];
for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        for (int[] edge : edges) {
    adj[edge[0]].add(new int[]{edge[1], edge[2]});
    adj[edge[1]].add(new int[]{edge[0], edge[2]});
}
dist[1] = 0;
for (int i = 0; i <= n; i++) parent[i] = i;
pq.add(new int[]{0, 1});

while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if (d > dist[node]) continue;

         for (int[] it : adj[node]) {
            int nextNode = it[0];
            int edgeWeight = it[1];

            if (d + edgeWeight < dist[nextNode]) {
    dist[nextNode] = d + edgeWeight;
    parent[nextNode] = node;
    pq.add(new int[]{dist[nextNode], nextNode});
}

    }

}
if (dist[n] == Integer.MAX_VALUE) return new ArrayList<>(Arrays.asList(-1));

List<Integer> path = new ArrayList<>();
int node = n;
while (parent[node] != node) {
    path.add(node);
    node = parent[node];
}
path.add(1); // add source

// Reverse the path
Collections.reverse(path);

path.add(0, dist[n]);

return path;
    }
}




