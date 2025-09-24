package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fraction-to-recurring-decimal/
public class FractionToRecurringDecimal {

    // Time complexity: O(denominator)
    // Space complexity: O(denominator)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();

            // get the result sign
            if (numerator < 0 ^ denominator < 0) {
                result.append("-");
            }

            // cast to long before Math.abs to handle Integer.MIN_VALUE safely
            long a = Math.abs((long) numerator);
            long b = Math.abs((long) denominator);

            long intPart = a / b;
            long decPart = a % b;

            result.append(intPart);

            if (decPart != 0) {
                result.append(".").append(getFractionalPart(b, decPart));
            }

            return result.toString();
        }

        private StringBuilder getFractionalPart(long b, long decPart) {
            StringBuilder fracPart = new StringBuilder();
            Map<Long, Integer> seen = new HashMap<>();
            while (decPart != 0) {
                if (seen.containsKey(decPart)) {
                    int position = seen.get(decPart);
                    fracPart.insert(position, "(").append(")");
                    return fracPart;
                }
                seen.put(decPart, fracPart.length());
                decPart *= 10;
                fracPart.append(decPart / b);
                decPart = decPart % b;
            }
            return fracPart;
        }
    }
}
