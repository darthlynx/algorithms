package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution {
        public int[][] merge(int[][] intervals) {
            LinkedList<int[]> mergedIntervals = new LinkedList<>();

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                // if empty or last interval does not intersect with new one (prevEnd <
                // newStart)
                if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < start) {
                    mergedIntervals.add(interval);
                } else {
                    mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], end);
                }
            }

            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }
    }

}
