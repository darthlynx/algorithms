package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
public class CheckIfGridCanBeCutIntoSections {

    // Time complexity: O(N * logN)
    // Space complexity: O(logN) for sorting
    class Solution {
        public boolean checkValidCuts(int n, int[][] rectangles) {
            return canCutVertical(rectangles) || canCutHorizontal(rectangles);
        }

        private boolean canCutVertical(int[][] rectangles) {
            return canCut(rectangles, 0); // X
        }

        private boolean canCutHorizontal(int[][] rectangles) {
            return canCut(rectangles, 1); // Y
        }

        private boolean canCut(int[][] rectangles, int dimention) {
            int gaps = 0;

            Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dimention], b[dimention]));
            int prevEnd = rectangles[0][dimention + 2];

            for (int[] rec : rectangles) {
                if (prevEnd <= rec[dimention]) {
                    gaps++;
                }
                prevEnd = Math.max(prevEnd, rec[dimention + 2]);
            }

            return gaps >= 2;
        }
    }
}
