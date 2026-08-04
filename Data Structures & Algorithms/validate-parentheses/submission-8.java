class Solution {
    public boolean isValid(String s) {
        Deque<Character> closingBrackets = new ArrayDeque<>();

        if (s.length() %2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '{') {
                closingBrackets.push('}');
            } else if (bracket == '[') {
                closingBrackets.push(']');
            } else if (bracket == '(') {
                closingBrackets.push(')');
            } else {
                if (closingBrackets.isEmpty()) {
                    return false;
                } else if (closingBrackets.pop() != bracket) {
                    return false;
                }
            }
        }

        return closingBrackets.isEmpty();
    }
}
