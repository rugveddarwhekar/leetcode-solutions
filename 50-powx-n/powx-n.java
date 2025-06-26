class Solution {
    public double myPow(double x, int n) {
        return rec1(x, (long) n);
    }
    public double rec(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) {
            n = -1*n;
            x = 1.0/x;
        }

        double res = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                res = res * x;
                n -= 1;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }

    private double rec1(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1.0/rec(x, -1 * n);
        if (n % 2 == 1) return x * rec(x * x, (n-1) / 2);
        else return rec(x * x, n / 2);
    }
}