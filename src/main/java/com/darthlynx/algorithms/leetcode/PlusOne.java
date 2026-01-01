package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/plus-one/
public class PlusOne {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
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

    // Time complexity: O(n)
    // Space complexity: O(1) (ignoring the output array)
    class Solution2 {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            int rem = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] + rem > 9) {
                    digits[i] = 0;
                    rem = 1;
                } else {
                    digits[i] = digits[i] + rem;
                    rem = 0;
                    break;
                }
            }

            if (rem == 1) {
                int[] res = new int[n + 1];
                res[0] = rem;
                for (int i = 0; i < n; i++) {
                    res[i + 1] = digits[i];
                }
                return res;
            } else {
                return digits;
            }
        }
    }
}
