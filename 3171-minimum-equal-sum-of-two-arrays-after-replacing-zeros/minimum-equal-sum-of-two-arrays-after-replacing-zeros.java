class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long count1 = 0, count2 = 0;
        for (int n1: nums1) {
            if (n1 == 0) count1++;
            sum1 += n1;
        }
        sum1 += count1;
        for (int n2: nums2) {
            if (n2 == 0) count2++;
            sum2 += n2;
        }
        sum2 += count2;
        if (sum1 == sum2) return sum1;
        if (sum1 > sum2) {
            if (count2 > 0) return sum1;
        } else {
            if (count1 > 0) return sum2;
        }
        return -1;
    }
}