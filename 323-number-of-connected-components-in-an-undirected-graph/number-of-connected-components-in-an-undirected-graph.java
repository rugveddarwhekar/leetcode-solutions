class Solution {
    class UnionFind {
        int components = 0;
        int[] parent;
        int[] rank;
        
        public UnionFind(int size) {
            components = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }
        
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
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
            components--;
        }
        
        public int totalComponents() {
            return components;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);
        
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        
        return dsu.totalComponents();
    }
}