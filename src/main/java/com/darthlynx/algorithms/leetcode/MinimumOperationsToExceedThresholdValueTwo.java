package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
public class MinimumOperationsToExceedThresholdValueTwo {

    // Time complexity: O(n*logn)
    // Space complexity: O(n)
    class Solution {
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                minHeap.offer((long) nums[i]);
            }
            int ops = 0;
            while (minHeap.size() >= 2 && minHeap.peek() < k) {
                long min = minHeap.poll();
                long max = minHeap.poll();
                long res = min * 2 + max;
                minHeap.offer(res);
                ops++;
            }
            return ops;
        }
    }
}
