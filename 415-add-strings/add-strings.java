class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 || n2 >= 0) {
            int sum = 0;
            if (n1 >= 0) {
                sum += (num1.charAt(n1) - '0');
                --n1;
            }
            if (n2 >= 0) {
                sum += (num2.charAt(n2) - '0');
                --n2;
            }
            sum += carry;
            sb.append(String.valueOf(sum%10));
            carry = sum / 10;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}