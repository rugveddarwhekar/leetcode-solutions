class Solution {
    public int minimumBuckets(String hamsters) {
        if (hamsters.equals("H")) return -1;
        if (hamsters.equals(".")) return 0;
        int n = hamsters.length();
        char[] arr = hamsters.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'H') {
                if (i < n-1 && arr[i+1] == '.') {
                    res++;
                    i += 2;
                } else if (i > 0 && arr[i-1] == '.') {
                    res++;
                } else {
                    return -1;
                }
            }
        }

        return res;
    }
}