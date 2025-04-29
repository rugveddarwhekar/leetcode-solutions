class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int currR = curr[0];
                int currC = curr[1];
                for (int[] dir : directions) {
                    int newR = currR + dir[0];
                    int newC = currC + dir[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        q.offer(new int[] { newR, newC });
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh == 0)
            return time;
        else
            return -1;

    }
}