class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            if (digits[0] < 9) {
                return new int[]{digits[0]+1};
            } else {
                return new int[]{1,0};
            }
        }

        for (int i = digits.length - 1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
