package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
public class FinalArrayStateAfterKMultiplicationOperations {

    // Time complexity: O((k + N) * logN), where N = nums.length
    // Space complexity: O(N)
    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
                if (nums[a] == nums[b]) {
                    return Integer.compare(a, b);
                } else {
                    return Integer.compare(nums[a], nums[b]);
                }
            });

            for (int i = 0; i < nums.length; i++) {
                heap.offer(i);
            }

            for (int i = 0; i < k; i++) {
                int idx = heap.poll();
                nums[idx] = nums[idx] * multiplier;
                heap.offer(idx);
            }

            return nums;
        }
    }

    // Time complexity: O(N * k)
    // Space complexity: O(1)
    class Solution2 {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
    
            for (int i = 0; i < k; i++) {
                int minIdx = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] < nums[minIdx]) {
                        minIdx = j;
                    }
                }
                nums[minIdx] *= multiplier;
            }
    
            return nums;
        }
    }
}
