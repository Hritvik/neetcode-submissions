class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = 0; i < digits.length; i++) {
            int j = digits.length - i - 1;
            if (digits[j] + carry > 9) {
                digits[j] = 0;
                carry = 1;
            } else if (carry > 0) {
                digits[j]++;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
