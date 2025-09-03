class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> ballCount = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballCount.containsKey(ball)) {
                int oldColor = ballCount.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);

                if (colorCount.get(oldColor) == 0)
                    colorCount.remove(oldColor);
            }
            ballCount.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            res[i] = colorCount.size();

        }

        return res;
    }
}