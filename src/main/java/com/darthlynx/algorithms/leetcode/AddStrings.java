package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/add-strings/
public class AddStrings {

    public String addStrings(String num1, String num2) {

        int pointer1 = num1.length() - 1;
        int pointer2 = num2.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (pointer1 >= 0 || pointer2 >= 0) {
            int sum = carry;
            if (pointer1 >= 0) {
                sum += num1.charAt(pointer1) - '0';
                pointer1--;
            }
            if (pointer2 >= 0) {
                sum += num2.charAt(pointer2) - '0';
                pointer2--;
            }
            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();

    }
}
