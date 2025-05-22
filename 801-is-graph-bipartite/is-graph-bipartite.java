class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
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
    public boolean isBipartite(int[][] graph) {
        UnionFind dsu = new UnionFind(graph.length);

        for (int i = 0; i < graph.length; i++) {
            int[] nodes = graph[i];
            for (int node: nodes) {
                if (dsu.find(i) == dsu.find(node)) return false;
                dsu.union(node, nodes[0]);
            }
        }
        return true;
    }
}