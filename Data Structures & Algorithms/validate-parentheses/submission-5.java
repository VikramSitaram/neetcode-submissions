class Solution {
    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        List<Character> openingBrackets = new LinkedList<>(List.of('{', '[', '('));

        if (s.length() %2 != 0) {
            return false;
        }

        for (int i=0;i<s.length(); i++) {
            char bracket = s.charAt(i);
            if (openingBrackets.contains(bracket)) {
                brackets.push(bracket);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }
                else if (bracket == '}' && brackets.pop() != '{') {
                    return false;
                } else if (bracket == ']' && brackets.pop() != '[') {
                    return false;
                } else if (bracket == ')' && brackets.pop() != '(') {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}
