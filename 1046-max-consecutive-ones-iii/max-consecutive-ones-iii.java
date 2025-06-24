class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int max = 0;

        while(right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}