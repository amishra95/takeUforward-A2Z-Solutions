class Solution {
    public int[] findOrder(int N, int[][] arr) {
         boolean[] visited = new boolean[N];
         boolean[] pathVisited = new boolean[N];


        

        Stack<Integer> stack = new Stack<>();
    List<List<Integer>> list = new ArrayList<>();
for (int i = 0; i < N; i++) list.add(new ArrayList<>());
for (int[] pre : arr) list.get(pre[1]).add(pre[0]);

       for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        if(dfs(i, visited, pathVisited, stack, list)){
            return new int[0];
        }
      }
    }
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      result[i] = stack.pop();
    }

    return result;



    }

public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack, List<List<Integer>> arr) {
    visited[node] = true;
    pathVisited[node] = true;

    for (int neighbor : arr.get(node)) {
        if (!visited[neighbor]) {
            if (dfs(neighbor, visited, pathVisited, stack, arr)) return true;
        } else if (pathVisited[neighbor]) return true;
    }

    pathVisited[node] = false;
    stack.push(node);
    return false;
}


}

