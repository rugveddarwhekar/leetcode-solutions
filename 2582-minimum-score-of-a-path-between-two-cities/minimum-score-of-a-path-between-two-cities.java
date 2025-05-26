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

    public int minScore(int n, int[][] roads) {
        UnionFind dsu = new UnionFind(n+1);
        for (int[] road : roads) {
            dsu.union(road[0], road[1]);
        }
        int answer = Integer.MAX_VALUE;

        for (int[] road : roads) {
            if (dsu.find(road[0]) == dsu.find(1)) {
                answer = Math.min(answer, road[2]);
            }
        }
        return answer;
    }
}