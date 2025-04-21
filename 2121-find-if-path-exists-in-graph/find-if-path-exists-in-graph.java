class Solution {
    // build a adjacency lsit from the provided edges array
    // use BFS to find the path between source and destination using the adj list
    // time: O(V + E) space: O(V + E) where V - number of nodes (visited), E - number of edges (hashmap)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>(); // adj list
        HashSet<Integer> visited = new HashSet<>(); //keep track of visited nodes
        Queue<Integer> q = new LinkedList<>(); // queue for BFS

        for (int[] edge: edges) {
            int src = edge[0];
            int dst = edge[1];

            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            if (!adjList.containsKey(dst)) {
                adjList.put(dst, new ArrayList<>());
            }
            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        q.offer(source);
        visited.add(source);

        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (curr == destination) {
                return true;
            }
            for (int i = 0; i < adjList.get(curr).size(); i++) {
                int curr_node = adjList.get(curr).get(i);
                if (!visited.contains(curr_node)) {
                    visited.add(curr_node);
                    q.offer(curr_node);
                }
            }
        }
        return false;
    }
}