package com.darthlynx.algorithms.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (lengthA >= 0 || lengthB >= 0) {
            int sum = carry;
            if (lengthA >= 0) {
                sum += a.charAt(lengthA) - '0';
                lengthA--;
            }
            if (lengthB >= 0) {
                sum += b.charAt(lengthB) - '0';
                lengthB--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
