package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
public class ConstructTheLexicographicallyLargestValidSequence {

    // Time complexity: O(n!)
    // Space complexity: O(n)
    class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] result = new int[2 * n - 1];
            Set<Integer> used = new HashSet<>();
            backtrack(0, n, result, used);
            return result;
        }

        private boolean backtrack(int index, int n, int[] result, Set<Integer> used) {
            int len = result.length;
            if (index == result.length) { // sequence is valid
                return true;
            }

            for (int num = n; num >= 1; num--) {
                if (used.contains(num)) {
                    continue;
                }
                // verify if second position is already taken
                if (num > 1 && (index + num >= len || result[index + num] > 0)) {
                    continue;
                }

                // 1. add current element
                used.add(num);
                if (num > 1) {
                    result[index + num] = num;
                }
                result[index] = num;

                // find next index
                int j = index + 1;
                while (j < len && result[j] > 0) {
                    j++;
                }

                // 2. backtrack
                if (backtrack(j, n, result, used)) {
                    return true;
                }

                // 3. remove current element
                used.remove(num);
                if (num > 1) {
                    result[index + num] = 0;
                }
                result[index] = 0;
            }

            return false;
        }
    }
}
