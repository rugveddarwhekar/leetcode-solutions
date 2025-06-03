class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currNum = 0, lastNum = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNum;
                    if (operation == '+') {
                        lastNum = currNum;
                    } else {
                        lastNum = -currNum;
                    }
                } else if (operation == '*') {
                    lastNum = lastNum * currNum;
                } else if (operation == '/') {
                    lastNum = lastNum / currNum;
                }
                operation = currChar;
                currNum = 0;
            }
        }

        result += lastNum;

        return result;
        
    }
}