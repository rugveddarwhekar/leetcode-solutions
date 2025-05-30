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

        public void union(int x, int y) {
            int xset = find(x);
            int yset = find(y);

            if (xset == yset) return;
            else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(n+1);
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            hm.put(i, new ArrayList<Integer>());
        }
        for (int[] dis: dislikes) {
            hm.get(dis[0]).add(dis[1]);
            hm.get(dis[1]).add(dis[0]);
        }
        for (int i = 1; i < hm.size(); i++) {
            for (int nei: hm.get(i)){
                if (uf.find(i) == uf.find(nei)) return false;
                uf.union(hm.get(i).get(0), nei);
            }
        }

        return true;
    }
}