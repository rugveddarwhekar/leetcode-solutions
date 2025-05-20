class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> hm = new HashMap<>(); // hm - componentSize
        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            if (hm.containsKey(parent)) {
                hm.put(parent, hm.get(parent) + 1);
            } else {
                hm.put(parent, 1);
            }
        }

        long numOfPaths = 0;
        long remainNodes = n;

        for (int size: hm.values()) {
            numOfPaths += size * (remainNodes - size);
            remainNodes -= size;
        }
        return numOfPaths;
    }
}

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
        else if (rank[xset] < rank[yset])
            parent[xset] = yset;
        else if (rank[xset] > rank[yset]) 
            parent[yset] = xset;
        else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}