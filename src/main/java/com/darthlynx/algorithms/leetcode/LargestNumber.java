package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            String[] sNums = new String[nums.length];

            for (int i = 0; i < nums.length; i++) {
                sNums[i] = Integer.toString(nums[i]);
            }

            Arrays.sort(sNums, this::compare);

            // handle cases like "000"
            if (sNums[0].startsWith("0")) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            for (String num : sNums) {
                result.append(num);
            }

            return result.toString();
        }

        private int compare(String a, String b) {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab); // reversed order
        }
    }
}
