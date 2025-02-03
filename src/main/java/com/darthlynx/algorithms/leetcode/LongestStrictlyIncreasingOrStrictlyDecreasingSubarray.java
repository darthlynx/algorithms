package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution1 {
        public int longestMonotonicSubarray(int[] nums) {
            int inc = 1;
            int dec = 1;
            int max = 1;
    
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    inc++;
                    dec = 1;
                } else if (nums[i + 1] < nums[i]) {
                    dec++;
                    inc = 1;
                } else {
                    dec = 1;
                    inc = 1;
                }
                max = Math.max(max, Math.max(inc, dec));
            }
            return max;
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution2 {
        public int longestMonotonicSubarray(int[] nums) {
            int maxIncreasing = 1;
            int maxDecreasing = 1;

            Stack<Integer> inc = new Stack<>();
            Stack<Integer> dec = new Stack<>();
            inc.add(nums[0]);
            dec.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                if (inc.peek() >= nums[i]) {
                    inc.removeAllElements();
                }
                inc.add(nums[i]);
                maxIncreasing = Math.max(maxIncreasing, inc.size());
                if (dec.peek() <= nums[i]) {
                    dec.removeAllElements();
                }
                dec.add(nums[i]);
                maxDecreasing = Math.max(maxDecreasing, dec.size());
            }

            return Math.max(maxIncreasing, maxDecreasing);
        }
    }
}
