class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = size; i > 0; i--) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d: direct) {
                    int R = r + d[0];
                    int C = c + d[1];
                    if (R >= 0 && C >= 0 && R < m && C < n && rooms[R][C] == Integer.MAX_VALUE) {
                        q.offer(new int[]{R, C});
                        rooms[R][C] = rooms[r][c] + 1;
                    }
                }
            }
        }
    }
}