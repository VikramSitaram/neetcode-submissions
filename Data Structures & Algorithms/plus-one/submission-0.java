class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            if (digits[0] < 9) {
                return new int[]{digits[0]+1};
            } else {
                return new int[]{1,0};
            }
        }

        boolean carry = false;
        if (digits[digits.length-1] == 9) {
            carry = true;
        } else {
            digits[digits.length-1]++;
        }

        for (int i=digits.length-1;i>=0;i--) {
            if (carry) {
                if (digits[i] == 9) {
                    carry = true;
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    carry = false;
                }
            }
        }

        if (carry) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i=1;i<result.length;i++) {
                result[i] = digits[i-1];
            }
            return result;
        }

        return digits;
    }
}
