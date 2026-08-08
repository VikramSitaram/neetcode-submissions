class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        if (s.length() == 1) {
            return roman.get(s.charAt(0));
        }

        int i = 0;
        int value = 0;

        while (i < s.length()) {
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                value -= roman.get(s.charAt(i));
            } else {
                value += roman.get(s.charAt(i));
            }
            i++;
        }

        return value;
    }
}