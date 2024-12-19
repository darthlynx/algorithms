package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/max-chunks-to-make-sorted/
public class MaxChunksToMakeSorted {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;

            int[] prefixMax = new int[n + 1];
            prefixMax[0] = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                prefixMax[i + 1] = Math.max(arr[i], prefixMax[i]);
            }

            int[] suffixMin = new int[n + 1];
            suffixMin[n] = arr[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            }

            int chunks = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || suffixMin[i] > prefixMax[i]) {
                    chunks++;
                }
            }

            return chunks;
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution2 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;

            Stack<Integer> monotonicStack = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (monotonicStack.isEmpty() || monotonicStack.peek() < arr[i]) {
                    monotonicStack.push(arr[i]);
                } else {
                    int currentMax = monotonicStack.pop();
                    while (!monotonicStack.isEmpty() && monotonicStack.peek() > arr[i]) {
                        monotonicStack.pop();
                    }
                    monotonicStack.push(currentMax);
                }
            }

            return monotonicStack.size();
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution3 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
    
            int chunks = 0;
            int max = 0;
    
            for (int i = 0; i < n; i++) {
                // finding the max value for current prefix
                max = Math.max(max, arr[i]);
                
                // since the range of numbers in arr is from 0 to n-1,
                // when we find the index i which is equal to max
                // we know that new chunk may be formed (because it has to include i)
                if (max == i) {
                    chunks++;
                }
            }
    
            return chunks;
        }
    }
}
