package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/finding-3-digit-even-numbers/
public class FindingThreeDigitEvenNumbers {

    // Time complexity: O(n), where n = digits.length
    // Space complexity: O(1)
    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int[] freq = new int[10];
            for (int digit : digits) {
                freq[digit]++;
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

        private boolean canConstruct(int num, int[] freq) {
            int[] count = new int[10];

            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                count[digit]++;
                temp /= 10;
            }

            for (int i = 0; i < count.length; i++) {
                if (count[i] > freq[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
