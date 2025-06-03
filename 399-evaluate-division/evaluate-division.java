class Solution {

    class UnionFind {
        private Map<String, String> parent;
        private Map<String, Double> ratio;

        public UnionFind() {
            parent = new HashMap<>();
            ratio = new HashMap<>();
        }

        public void addVariable(String s) {
            if (!parent.containsKey(s)) {
                parent.put(s, s);
                ratio.put(s, 1.0);
            }
        }

        public String find(String s) {
            if (!parent.containsKey(s)) {
                return null;
            }
            if (parent.get(s).equals(s)) {
                return s;
            }
            String oldParent = parent.get(s);
            String root = find(oldParent);

            parent.put(s, root);
            ratio.put(s, ratio.get(s) * ratio.get(oldParent));

            return root;
        }

        public void union(String x, String y, double val) {
            addVariable(x);
            addVariable(y);

            String rootX = find(x);
            String rootY = find(y);

            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
                
                ratio.put(rootX, val * ratio.get(y) / ratio.get(x));
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double val = values[i];
            uf.union(A, B, val);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);

            if (!uf.parent.containsKey(C) || !uf.parent.containsKey(D)) {
                results[i] = -1.0;
            } else {
                String rootC = uf.find(C);
                String rootD = uf.find(D);

                if (!rootC.equals(rootD)) {
                    results[i] = -1.0;
                } else {
                    results[i] = uf.ratio.get(C) / uf.ratio.get(D);
                }
            }
        }
        return results;
    }
}