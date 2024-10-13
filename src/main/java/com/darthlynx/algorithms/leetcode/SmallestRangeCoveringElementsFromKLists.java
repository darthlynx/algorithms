package com.darthlynx.algorithms.leetcode;

import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class SmallestRangeCoveringElementsFromKLists {

    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int k = nums.size();

            // Priority queue to store (value, list index, element index)
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );
            int maxVal = Integer.MIN_VALUE;
            int rangeStart = 0;
            int rangeEnd = Integer.MAX_VALUE;
    
            // Insert the first element from each list into the min-heap
            for (int i = 0; i < k; i++) {
                pq.offer(new int[] { nums.get(i).get(0), i, 0 });
                maxVal = Math.max(maxVal, nums.get(i).get(0));
            }
    
            // Continue until we can't proceed further
            while (pq.size() == k) {
                int[] data = pq.poll(); // extracting smallest element
                int minVal = data[0];
                int listIdx = data[1];
                int elementIdx = data[2];
    
                // Update the smallest range
                if (maxVal - minVal < rangeEnd - rangeStart) {
                    rangeStart = minVal;
                    rangeEnd = maxVal;
                }
    
                // If possible, add the next element from the same row to the heap
                // to maintain the k size of the queue (to ensure we have numbers from all lists)
                if (elementIdx + 1 < nums.get(listIdx).size()) {
                    int nextVal = nums.get(listIdx).get(elementIdx + 1);
                    pq.offer(new int[] { nextVal, listIdx, elementIdx + 1 });
                    maxVal = Math.max(maxVal, nextVal);
                }
            }
    
            return new int[] { rangeStart, rangeEnd };
        }
    }
}
