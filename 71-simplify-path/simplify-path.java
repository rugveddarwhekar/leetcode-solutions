class Solution {
    public String simplifyPath(String path) {
        // create a stack of tokens from the path using "/" delimiter
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for (String token: tokens) {
            if (token.isEmpty()) continue;
            if (token.equals(".")) continue;
            if (token.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String currToken = stack.pop();
            currToken = "/" + currToken;
            sb.insert(0, currToken);
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }
}