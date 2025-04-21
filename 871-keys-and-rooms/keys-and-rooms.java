class Solution {
//bfs
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int currRoom = q.poll();
            
            for (int nextRoom: rooms.get(currRoom)) {
                if (visited.add(nextRoom)) {
                    q.offer(nextRoom);
                }
            }
        }

        return visited.size() == n;
    }
}

//dfs
    // private Map<Integer, List<Integer>> preMap = new HashMap<>();
    // private Set<Integer> visited;
    // public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    //     int n = rooms.size();
    //     visited =  new HashSet<>();

    //     dfs(0, rooms);

    //     return visited.size() == n;
    // }

    // // dfs & bfs time and space
    // // Time: O(N + E) where N: no of rooms, E: total no of keys across all rooms
    // // Space: O(N)
    // private void dfs(int currRoom, List<List<Integer>> rooms) {
    //     visited.add(currRoom);
    //     List<Integer> currKeys = rooms.get(currRoom);

    //     for (int nextRoom: currKeys) {
    //         if (!visited.contains(nextRoom)) {
    //             dfs(nextRoom, rooms);
    //         }
    //     }
    // }
