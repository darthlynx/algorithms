package com.darthlynx.algorithms.leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int pointer = digits.length - 1;

        StringBuilder builder = new StringBuilder();
        while (pointer >= 0) {
            int sum = carry;
            sum += digits[pointer];
            pointer--;
            builder.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            builder.append(carry);
        }

        return stringToIntArray(builder.reverse().toString());

    }

    private int[] stringToIntArray(String resultString) {
        char[] chars = resultString.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }
        return ints;
    }
}
