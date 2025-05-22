class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;
        int component;

        public UnionFind(int x) {
            parent = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
            }
            rank = new int[x];
            component = x;
        }

        public int find(int x) { // path compression
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) { // union by rank
            int xset = find(x);
            int yset = find(y);

            if (xset == yset) return;
            else if (rank[xset] < rank[yset]) parent[xset] = yset;
            else if (rank[xset] > rank[yset]) parent[yset] = xset;
            else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind dsu = new UnionFind(n);

        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }

        return dsu.find(source) == dsu.find(destination);
    }
    // // build a adjacency lsit from the provided edges array
    // // use BFS to find the path between source and destination using the adj list
    // // time: O(V + E) space: O(V + E) where V - number of nodes (visited), E - number of edges (hashmap)
    // public boolean validPath(int n, int[][] edges, int source, int destination) {
    //     HashMap<Integer, List<Integer>> adjList = new HashMap<>(); // adj list
    //     HashSet<Integer> visited = new HashSet<>(); //keep track of visited nodes
    //     Queue<Integer> q = new LinkedList<>(); // queue for BFS

    //     for (int[] edge: edges) {
    //         int src = edge[0];
    //         int dst = edge[1];

    //         if (!adjList.containsKey(src)) {
    //             adjList.put(src, new ArrayList<>());
    //         }
    //         if (!adjList.containsKey(dst)) {
    //             adjList.put(dst, new ArrayList<>());
    //         }
    //         adjList.get(src).add(dst);
    //         adjList.get(dst).add(src);
    //     }

    //     q.offer(source);
    //     visited.add(source);

    //     while (!q.isEmpty()) {
    //         int curr = q.poll();
            
    //         if (curr == destination) {
    //             return true;
    //         }
    //         for (int i = 0; i < adjList.get(curr).size(); i++) {
    //             int curr_node = adjList.get(curr).get(i);
    //             if (!visited.contains(curr_node)) {
    //                 visited.add(curr_node);
    //                 q.offer(curr_node);
    //             }
    //         }
    //     }
    //     return false;
    // }
}