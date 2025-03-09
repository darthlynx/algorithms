package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/alternating-groups-ii/
public class AlternatingGroupsII {

    // Time complexity: O(2*n) ~> O(n)
    // Space complexity: O(n)
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int[] doubledColors = new int[colors.length * 2];

            for (int i = 0; i < colors.length; i++) {
                doubledColors[i] = colors[i];
                doubledColors[i + colors.length] = colors[i];
            }

            int left = 0;
            int right = 1;
            int result = 0;

            while (right < colors.length + k - 1) { // we do not expore entire array second time to avoid duplicates
                // pattern broken
                if (doubledColors[right] == doubledColors[right - 1]) {
                    left = right;
                    right++;
                    continue;
                }
                right++;

                if (right - left == k) { // pattern with required length
                    result++;
                    left++; // reset left to explore new options
                }
            }

            return result;
        }
    }
}
