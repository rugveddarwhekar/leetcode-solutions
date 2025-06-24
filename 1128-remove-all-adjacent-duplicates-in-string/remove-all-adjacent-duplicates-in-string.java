class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

// variant -> remove all dupes from string not only adjecent

public class Solution1 {

    private static class Letter {
        char val;
        int freq;

        Letter(char val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public String removeAllAdjacentDuplicatesVariant(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Deque<Letter> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(new Letter(ch, 1));
                continue;
            }

            if (stack.peekLast().val == ch) {
                stack.peekLast().freq++;
                continue;
            }

            if (stack.peekLast().freq > 1) {
                stack.removeLast();
            }

            if (stack.isEmpty() || stack.peekLast().val != ch) {
                stack.addLast(new Letter(ch, 1));
            } else {
                stack.peekLast().freq++;
            }
        }

        if (!stack.isEmpty() && stack.peekLast().freq > 1) {
            stack.removeLast();
        }

        StringBuilder result = new StringBuilder();
        for (Letter letter : stack) {
            result.append(letter.val);
        }

        return result.toString();
    }
}}
