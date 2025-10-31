package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
public class TheTwoSneakyNumbersOfDigitville {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int[] result = new int[2];
            Arrays.fill(result, -1);

            Map<Integer, Integer> freq = new HashMap<>();

            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                if (freq.get(num) > 1) {
                    if (result[0] >= 0) {
                        result[1] = num;
                        break;
                    } else {
                        result[0] = num;
                    }
                }
            }

            return result;
        }
    }
}
