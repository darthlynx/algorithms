package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
public class FindScoreOfAnArrayAfterMarkingAllElements {

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution {
        public long findScore(int[] nums) {
            boolean[] marked = new boolean[nums.length];

            // queue of pair (num, index)
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            for (int i = 0; i < nums.length; i++) {
                minHeap.offer(new int[] { nums[i], i });
            }

            long score = 0L;
            while (!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                if (!marked[current[1]]) {
                    mark(current[1], marked);
                    score += current[0];
                }
            }

            return score;
        }

        private void mark(int index, boolean[] marked) {
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < marked.length - 1) {
                marked[index + 1] = true;
            }
        }
    }
}
