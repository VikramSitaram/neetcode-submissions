class Solution {
    public String intToRoman(int num) {
        String[] roman = new String[] {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        int[] values = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder romanStr = new StringBuilder("");
        for (int i = 0; i < values.length; i++) {
            int value = values[i];

            while (num >= value) {
                if (num == 0) {
                    break;
                }

                romanStr.append(roman[i]);
                num -= values[i];
            }
        }

        return romanStr.toString();
    }
}