package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/most-beautiful-item-for-each-query/
public class MostBeautifulItemForEachQuery {

    // Time complexity: O(M * N*logN), where M - length of queries, N - length of items
    // Space complexity: O(logN) - space required for Java Quick Sort
    class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

            int currMax = items[0][1];
            for (int i = 0; i < items.length; i++) {
                currMax = Math.max(currMax, items[i][1]);
                // modifying beauty with the max beauty found so far
                // it gives us possibility to get max possible beauty in constant time
                items[i][1] = currMax; 
            }

            int[] result = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                result[i] = getMostBeautifulItem(items, queries[i]);
            }

            return result;
        }

        private int getMostBeautifulItem(int[][] items, int targetPrice) {
            int good = -1;
            int bad = items.length;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;

                if (items[mid][0] <= targetPrice) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good >= 0 ? items[good][1] : 0;
        }
    }
}
