class Solution {

    class DSU {
        int[] parent, rank;
        int size;

        DSU(int size) {
            this.size = size;
            parent = new int[size];
            rank = new int[size];
            initialize();
        }

        void initialize() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (node == parent[node])
                return node;
            else
                return parent[node] = find(parent[node]); // path compression
        }

        void union(int x, int y) {
            int xprnt = find(x);
            int yprnt = find(y);
            if (xprnt == yprnt)
                return;
            if (rank[xprnt] > rank[yprnt]) {
                parent[yprnt] = xprnt;
            } else if (rank[xprnt] < rank[yprnt]) {
                parent[xprnt] = yprnt;
            } else {
                parent[yprnt] = xprnt;
                rank[xprnt] += 1;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DSU dsu = new DSU(rows * cols);
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // join with adjacent land cells
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dirs[k][0];
                        int nc = j + dirs[k][1];
                        if (inBound(nr, nc, rows, cols) && grid[nr][nc] == '1') {
                            dsu.union(i * cols + j, nr * cols + nc);
                        }
                    }
                }
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result.add(dsu.find(i * cols + j));
                }
            }
        }

        return result.size();
    }

    boolean inBound(int r, int c, int rl, int cl) {
        return r >= 0 && r < rl && c >= 0 && c < cl;
    }
}