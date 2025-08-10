package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/reordered-power-of-2/
public class ReorderedPowerOfTwo {

    // Time complexity: O(d*logd)
    // where d - number of digits in the power of 2 numbers
    // Space complexity: O(k * d) ~> O(1)
    // Technically, d - max number of digits in power of 2 number;
    // k - number of those numbers in the range.
    // But in current range we will have only ~30 numbers
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            Map<String, Integer> powTwo = new HashMap<>();

            int num = 1;
            while (num <= 1000000000) {
                powTwo.put(getKey(num), num);
                num *= 2;
            }

            String nKey = getKey(n);
            return powTwo.containsKey(nKey);
        }

        private String getKey(int i) {
            char[] s = Integer.toString(i).toCharArray();
            Arrays.sort(s);
            return new String(s);
        }
    }
}
