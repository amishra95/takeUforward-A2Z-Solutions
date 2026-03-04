    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

            List<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[V];

            Queue<Integer> queue = new LinkedList<>();
            visited[0] = true;
            queue.offer(0);

            while(!queue.isEmpty()){
                int node = queue.poll();
                list.add(node);

                for(int neighbor: adj.get(node)){
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            return list;
    }
}

