class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
        );

        if (s.length() == 1) {
            return roman.get(s.charAt(0));
        }

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                value -= roman.get(s.charAt(i));
            } else {
                value += roman.get(s.charAt(i));
            }
        }

        return value;
    }
}