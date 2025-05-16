class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int i = 2;
        while (i < n) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            i++;
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}