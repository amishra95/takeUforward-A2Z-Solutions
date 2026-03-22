import java.util.*;

class DisjointSet {
  public int[] rank;
  public int[] size;
  public int[] parent;

  public DisjointSet(int n) {
    rank = new int[n + 1];
    parent = new int[n + 1];
    size = new int[n + 1];
    Arrays.fill(size, 1);

    for (int i = 0; i <= n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    
  }
  public int findUPar(int node){
        if(node == parent[node])
            return node;
        
            return parent[node] = findUPar(parent[node]);

    }
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }



}

class Solution {

  public int solve(int n, int[][] Edge) {
    int size = Edge.length;

    if(size < n-1) return -1;

    DisjointSet ds = new DisjointSet(n);

    for(int i = 0; i < size; i++){
        ds.unionByRank(Edge[i][0], Edge[i][1]);
    }
    int count = 0;

    for(int i = 0; i < n; i++){
        if(ds.parent[i] == i) count++;
    }
    return count-1;
  }
}
