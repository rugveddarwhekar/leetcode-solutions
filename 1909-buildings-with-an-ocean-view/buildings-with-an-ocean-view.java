class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();
        int n = heights.length;
        int currMax = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            if (heights[i] > currMax) {
                res.add(0, i);
                currMax = heights[i];
            }
        }
        int[] sol = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            sol[i] = res.get(i);
        }

        return sol;
    }
}