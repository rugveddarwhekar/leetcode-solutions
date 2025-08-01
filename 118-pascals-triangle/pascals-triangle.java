class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            List<Integer> curr = new ArrayList<>(n);
            curr.add(1);
            if (n > 0) {
                List<Integer> prev = res.get(n - 1);
                for (int i = 1; i < n; i++) {
                    curr.add(prev.get(i - 1) + prev.get(i));
                }
                curr.add(1);
            }
            res.add(curr);
        }
        return res;
    }
}