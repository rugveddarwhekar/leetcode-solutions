class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) return "equilateral";
            if (a == b || a == c || b == c) return "isosceles";
            else return "scalene";
        }
        else return "none";
    }
}