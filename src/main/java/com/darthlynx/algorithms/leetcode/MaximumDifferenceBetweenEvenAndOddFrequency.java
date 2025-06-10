package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
public class MaximumDifferenceBetweenEvenAndOddFrequency {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int maxDifference(String s) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            int maxOdd = Integer.MIN_VALUE;
            int minEven = Integer.MAX_VALUE;

            for (int f : freq) {
                if (f == 0) {
                    continue;
                }
                if (f % 2 == 0) {
                    minEven = Math.min(minEven, f);
                } else {
                    maxOdd = Math.max(maxOdd, f);
                }
            }

            return maxOdd - minEven;
        }
    }
}
