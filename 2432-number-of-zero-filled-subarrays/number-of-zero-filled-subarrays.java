class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0;
        for (int n: nums) {
            if (n == 0) {
                count++;
            } else {
                res += count * (count + 1) / 2;
                count = 0;
            }
        }

        if (count > 0) {
            res += count * (count + 1) / 2;
        }
        return res;
    }
}