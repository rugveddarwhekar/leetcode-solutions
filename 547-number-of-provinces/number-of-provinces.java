class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Union dsu = new Union(n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i);
            hs.add(p);
        }

        return hs.size();
    }
}

class Union {
    int[] parent;
    int[] rank;

    public Union(int size) {
        parent = new int[size];
        for (int i = 0 ; i < size; i++) {
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