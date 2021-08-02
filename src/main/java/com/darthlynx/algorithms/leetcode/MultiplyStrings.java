package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];

        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int digit, carry;
        for (int i1 = 0; i1 < n1.length; i1++) {
            for (int i2 = 0; i2 < n2.length; i2++) {
                digit = toInt(n1[i1]) * toInt(n2[i2]) + res[i1 + i2];
                res[i1 + i2] = digit % 10;
                carry = digit / 10;
                res[i1 + i2 + 1] += carry;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int num : res) {
            result.append(num);
        }

        removeLeadingZeroes(result.reverse());

        return result.toString();
    }

    private void removeLeadingZeroes(StringBuilder result) {
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
    }

    private int toInt(char ch) {
        return ch - '0';
    }

}
