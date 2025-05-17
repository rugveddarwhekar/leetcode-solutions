class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int red = 0, white = 0, blue = 0;
        for (int n: nums) {
            if (n == 0) red++;
            else if (n == 1) white++;
            else if (n == 2) blue++;
        }
        for (int i = 0; i < len; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else {
                nums[i] = 2;
                blue--;
            }
        }        
    }
}