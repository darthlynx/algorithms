package com.darthlynx.algorithms.leetcode;

//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    class Solution1 {
        public int minimumRecolors(String blocks, int k) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i <= blocks.length() - k; i++) {
                int black = 0;
                for (int j = i; j < i + k; j++) {
                    if (blocks.charAt(j) == 'B') {
                        black++;
                    }
                }
                min = Math.min(min, k - black);
            }

            return min;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int minimumRecolors(String blocks, int k) {
            // B W B B W
            // 1 1 2 3 3

            int[] prefix = new int[blocks.length() + 1];

            for (int i = 0; i < blocks.length(); i++) {
                int black = blocks.charAt(i) == 'B' ? 1 : 0;
                prefix[i + 1] = prefix[i] + black;
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i <= blocks.length() - k; i++) {
                int black = prefix[i + k] - prefix[i];
                min = Math.min(min, k - black);
            }

            return min;
        }
    }
}
