package com.darthlynx.algorithms.neetcode.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://neetcode.io/problems/top-k-elements-in-list
public class TopKElementsInList {

    // Time complexity: O(n * logk)
    // Space complexity: O(n + k)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.getValue(), b.getValue()));

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                heap.offer(entry);
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            int[] res = new int[k];
            int i = 0;
            while (!heap.isEmpty()) {
                res[i] = heap.poll().getKey();
                i++;
            }
            return res;
        }
    }

}
