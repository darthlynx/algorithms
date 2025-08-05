package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/fruits-into-baskets-ii/
public class FruitsIntoBasketsII {

    // Time complexity: O(m*n)
    // Space complexity: O(n)
    // where m = fruits.length, n = basket.length;
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int unplaced = 0;
            boolean[] used = new boolean[baskets.length];

            for (int i = 0; i < fruits.length; i++) {
                boolean placed = false;
                for (int j = 0; j < baskets.length; j++) {
                    if (used[j] == true || fruits[i] > baskets[j]) {
                        continue;
                    }
                    used[j] = true;
                    placed = true;
                    break;
                }
                if (!placed) {
                    unplaced++;
                }
            }

            return unplaced;
        }
    }
}
