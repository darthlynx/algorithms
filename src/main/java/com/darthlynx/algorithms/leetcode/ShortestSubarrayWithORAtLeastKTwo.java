package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/
public class ShortestSubarrayWithORAtLeastKTwo {

    // Time complexity: O(n), where n - length of nums array
    // Space complexity: O(1), because we always use array of size 32 for bits counting
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int minLength = Integer.MAX_VALUE;
    
            int[] bitCounts = new int[32]; // Tracks count of set bits at each position
    
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // add
                add(bitCounts, nums[right]);
                // while good
                while (left <= right && isGood(bitCounts, k)) {
                    remove(bitCounts, nums[left]);
                    minLength = Math.min(minLength, right - left + 1);
                    left++;
                }
            }
    
            return minLength == Integer.MAX_VALUE ? -1 : minLength;
        }
    
        private boolean isGood(int[] bitCounts, int k) {
            return convertBitCountsToNumber(bitCounts) >= k;
        }
    
        // Converts bit count array back to number using OR operation
        private int convertBitCountsToNumber(int[] bitCounts) {
            int result = 0;
            for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
                if (bitCounts[bitPosition] != 0) {
                    result |= 1 << bitPosition;
                }
            }
            return result;
        }
    
        // For each bit position from 0 to 31
        // Check if bit is set in given number using right shift and AND operation
        // and increment count in that position by 1
        private void add(int[] bitCounts, int number) {
            for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
                // Check if bit is set at current position
                if (((number >> bitPosition) & 1) != 0) {
                    bitCounts[bitPosition] += 1;
                }
            }
        }
    
        // No bit operation can "subtract" nums[start] from the current window, 
        // because of the nature of OR:
        // Given 1 | x == 1, there is no way to find the value of x, as both 1 | 0 and 1 | 1 equals 1, so x can be either 0 or 1.
        // Therefore, we need to count bits
        private void remove(int[] bitCounts, int number) {
            for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
                // Check if bit is set at current position
                if (((number >> bitPosition) & 1) != 0) {
                    bitCounts[bitPosition] -= 1;
                }
            }
        }
    }
}
