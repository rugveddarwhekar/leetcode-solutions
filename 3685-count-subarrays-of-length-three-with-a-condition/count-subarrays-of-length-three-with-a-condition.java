class Solution {
    public int countSubarrays(int[] nums) {
        int left = 0, right = left + 2, mid = left + 1;
        int res = 0;
        while (right < nums.length) {
            if (2 * (nums[left] + nums[right]) == nums[mid]) ++res;
            left++;
            right++;
            mid++;
        }
        return res;
    }
}