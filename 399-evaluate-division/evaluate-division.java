class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double val = values[i];

            if (!map.containsKey(var1)) {
                map.put(var1, new HashMap<>());
            }
            map.get(var1).put(var2, val);

            if (!map.containsKey(var2)) {
                map.put(var2, new HashMap<>());
            }
            map.get(var2).put(var1, 1.0/val);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String queryStart = queries.get(i).get(0);
            String queryEnd = queries.get(i).get(1);

            if (!map.containsKey(queryStart) || !map.containsKey(queryEnd)) {
                results[i] = -1.0;
                continue;
            }

            if (queryStart.equals(queryEnd)) {
                results[i] = 1.0;
                continue;
            }

            Stack<Object[]> stack = new Stack<>();
            Set<String> visited = new HashSet<>();

            stack.push(new Object[]{queryStart, 1.0});
            visited.add(queryStart);

            double currResult = -1.0;

            while (!stack.isEmpty()) {
                Object[] curr = stack.pop();
                String currNode = (String) curr[0];
                double currVal = (double) curr[1];

                if (currNode.equals(queryEnd)) {
                    currResult = currVal;
                    break;
                } 

                Map<String, Double> neighbors = map.get(currNode);
                if (neighbors != null) {
                    for (Map.Entry<String, Double> neiEntry: neighbors.entrySet()) {
                        String nei = neiEntry.getKey();
                        double weight = neiEntry.getValue();

                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            stack.push(new Object[]{nei, currVal * weight});
                        }
                    }
                }
            }

            results[i] = currResult;
        }
        return results;
    }
}