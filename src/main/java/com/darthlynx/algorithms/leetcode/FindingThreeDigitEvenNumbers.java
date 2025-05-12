package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/finding-3-digit-even-numbers/
public class FindingThreeDigitEvenNumbers {

    // Time complexity: O(n), where n = digits.length
    // Space complexity: O(1)
    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int digit : digits) {
                freq.put(digit, freq.getOrDefault(digit, 0) + 1);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 100; i < 1000; i += 2) {
                if (canConstruct(i, freq)) {
                    result.add(i);
                }
            }

            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        private boolean canConstruct(int num, Map<Integer, Integer> freq) {
            int[] count = new int[10];

            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                count[digit]++;
                temp /= 10;
            }

            for (int i = 0; i < count.length; i++) {
                if (count[i] > freq.getOrDefault(i, 0)) {
                    return false;
                }
            }

            return true;
        }
    }
}
