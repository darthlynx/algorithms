package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
public class ShortestSubarrayWithSumAtLeastK {

    // DOES NOT WORK because of the negative integers in nums
    class Solution1 {
        public int shortestSubarray(int[] nums, int k) {

            int shortest = Integer.MAX_VALUE;
    
            int left = 0;
            int currSum = 0;
            for (int right = 0; right < nums.length; right++) {
                currSum += nums[right];
                while (currSum - nums[left] >= k && left <= right) {
                    currSum -= nums[left];
                    left++;
                }
                if (currSum >= k) {
                    shortest = Math.min(shortest, right - left + 1);
                }
            }
    
            return shortest == Integer.MAX_VALUE ? -1 : shortest;
        }
    }

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution2 {

        static class Pair {
            long sum;
            int index;

            Pair(long sum, int index) {
                this.sum = sum;
                this.index = index;
            }
        }

        public int shortestSubarray(int[] nums, int k) {
            int shortest = Integer.MAX_VALUE;
            
            PriorityQueue<Pair> prefixSum = new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));
            
            long currSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];

                if (currSum >= k) {
                    shortest = Math.min(shortest, i + 1);
                }

                // trying to remove the smallest prefixSum we have seen so far to minimize currSum
                // if result is >= k, we could update the `shortest` value
                while (!prefixSum.isEmpty() && currSum - prefixSum.peek().sum >= k) {
                    shortest = Math.min(shortest, i - prefixSum.poll().index);
                }

                prefixSum.offer(new Pair(currSum, i));
            }

            return shortest == Integer.MAX_VALUE ? -1 : shortest;
        }
    }
}
