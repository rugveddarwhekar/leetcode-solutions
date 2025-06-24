class Solution {
    public boolean makePalindrome(String s) {
        int N = s.length();
        int count = 0;
        for (int i = 0; i < N/2; i++) {
            if (s.charAt(i) != s.charAt(N - i - 1)) {
                count++;
            }
        }
        if (count >= 0 && count <= 2) return true;
        return false;
    }
}