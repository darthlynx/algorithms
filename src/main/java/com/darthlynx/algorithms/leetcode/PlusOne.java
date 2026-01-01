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

            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] + 1 <= 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }

            // if not exited by this point, we need to create new array
            // (e.g. corner case: 99 + 1 = 100)
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
    }
}
