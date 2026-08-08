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
            int num = roman.get(s.charAt(i));

            int prevNum = 0;
            if (i > 0) {
                prevNum = roman.get(s.charAt(i - 1));
            }

            if (prevNum < num) {
                value = value + num - (2 * prevNum);
            } else {
                value += num;
            }
        }

        return value;
    }
}