class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeLimited(String s, char[] values) {
        HashSet<Character> hs = new HashSet<>();
        for (char v: values) hs.add(v);
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!hs.contains(s.charAt(left)) && left < right) {
                left++;
            }
            while (!hs.contains(s.charAt(right)) && left < right) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}