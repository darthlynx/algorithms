package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class FindNUniqueIntegersSumUpToZero {

    // Time complexity: O(n)
    // Space complexity: O(1) if we don't count result array, O(n) otherwise
    class Solution {
        public int[] sumZero(int n) {
            int[] res = new int[n];
            if (n % 2 != 0) {
                res[n / 2] = 0;
            }
            int startValue = n / 2;
            int left = 0, right = n - 1;
            while (left < right) {
                res[left] = -1 * startValue;
                res[right] = startValue;
                startValue--;
                left++;
                right--;
            }
            return res;
        }
    }
}
