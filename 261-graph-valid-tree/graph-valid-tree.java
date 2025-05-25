class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xset = find(x);
            int yset = find(y);

            if (xset == yset) {
                return false;
            }
            if (rank[xset] < rank[yset]) {
                parent[yset] = xset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                xset++;
            }
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        if (edges.length != n - 1) return false;
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (!uf.union(a, b)) return false;
        }
        return true;
    }
}