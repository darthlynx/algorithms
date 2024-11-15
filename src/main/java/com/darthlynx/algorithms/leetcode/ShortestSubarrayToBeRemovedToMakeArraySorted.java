package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int left = 0;
            // find longest increasing prefix
            while (left < arr.length - 1) {
                if (arr[left] <= arr[left + 1]) {
                    left++;
                } else {
                    break;
                }
            }
    
            if (left == arr.length - 1) {
                return 0; // nothing to remove
            }
    
            int right = arr.length - 1;
            // find longest increasing suffix
            while (right > 0) {
                if (arr[right] >= arr[right - 1]) {
                    right--;
                } else {
                    break;
                }
            }

            int count = Math.min(right, arr.length - left - 1);
    
            int i = 0;
            int j = right;
            while (i <= left && j < arr.length) {
                if (arr[i] <= arr[j]) {
                    count = Math.min(count, j - i - 1);
                    i++;
                } else {
                    j++;
                }
            }
    
            return count;
        }
    }
}
