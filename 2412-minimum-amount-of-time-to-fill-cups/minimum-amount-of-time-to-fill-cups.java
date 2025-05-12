class Solution {
    public int fillCups(int[] amount) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < amount.length; i++) {
            sum += amount[i];
            max = Math.max(max, amount[i]);
        }

        sum = sum % 2 == 0 ? sum / 2 : (sum + 1) / 2;

        if (sum > max) return sum;

        return max;
    }
}