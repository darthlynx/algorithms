package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

// https://leetcode.com/problems/continuous-subarrays/
public class ContinuousSubarrays {

    // Time complexity: O(N * logK), where K - number of entries in TreeMap (could
    // not exceed 3 in this case)
    // Space complexity: O(K) => O(1)
    class Solution {
        public long continuousSubarrays(int[] nums) {
            // to collect the numbers in the subarray
            // diff between first and last element shouldn't be more than 2
            TreeMap<Integer, Integer> freq = new TreeMap<>();

            long count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // add
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

                // while not good (max - min > 2)
                while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                    // remove left
                    if (freq.get(nums[left]) - 1 == 0) {
                        freq.remove(nums[left]);
                    } else {
                        freq.put(nums[left], freq.get(nums[left]) - 1);
                    }
                    left++;
                }
                count += right - left + 1;
            }

            return count;
        }
    }

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution2 {
        public long continuousSubarrays(int[] nums) {

            // min and max heap sort indices based on their nums value
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));

            long count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // add
                minHeap.offer(right);
                maxHeap.offer(right);

                // while not good
                while (left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2) {
                    // remove indices outside the window
                    left++;
                    while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                        maxHeap.poll();
                    }
                    while (!minHeap.isEmpty() && minHeap.peek() < left) {
                        minHeap.poll();
                    }
                }
                count += right - left + 1;
            }

            return count;
        }
    }
}
