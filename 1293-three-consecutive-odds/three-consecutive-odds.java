class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int a: arr) {
            if (count == 3) return true;
            if (a % 2 != 0) count++;
            else count = 0;
        }
        if (count == 3) return true;
        return false;
    }
}