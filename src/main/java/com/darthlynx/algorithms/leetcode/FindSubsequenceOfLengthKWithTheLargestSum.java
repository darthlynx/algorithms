package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
public class FindSubsequenceOfLengthKWithTheLargestSum {

    // Time complexity: O(n * logn)
    // Space complexity: O(n)
    class Solution1 {
        public int[] maxSubsequence(int[] nums, int k) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

            for (int i = 0; i < nums.length; i++) {
                minHeap.offer(new int[] { nums[i], i });
                // keep the size of the heap not more than k
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            List<int[]> toSort = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                toSort.add(minHeap.poll());
            }

            Collections.sort(toSort, (a, b) -> Integer.compare(a[1], b[1]));
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = toSort.get(i)[0];
            }

            return result;
        }
    }

    // Time complexity: O(n * logn)
    // Space complexity: O(n)
    class Solution2 {
        public int[] maxSubsequence(int[] nums, int k) {

            int[][] biggest = new int[nums.length][];
            for (int i = 0; i < nums.length; i++) {
                biggest[i] = new int[] { nums[i], i };
            }

            // sort in descending order to find k biggest numbers
            Arrays.sort(biggest, (a, b) -> Integer.compare(b[0], a[0]));

            // sort first k elements by index
            Arrays.sort(biggest, 0, k, (a, b) -> Integer.compare(a[1], b[1]));

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = biggest[i][0];
            }

            return result;
        }
    }
}
