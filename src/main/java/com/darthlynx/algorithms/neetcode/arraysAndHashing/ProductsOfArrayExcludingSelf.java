package com.darthlynx.algorithms.neetcode.arraysAndHashing;

// https://neetcode.io/problems/products-of-array-discluding-self/question
public class ProductsOfArrayExcludingSelf {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] suffix = new int[n];

            prefix[0] = nums[0];
            suffix[n - 1] = nums[n - 1];

            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] * nums[i];
            }

            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i];
            }

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                int res = 1;
                if (i > 0) {
                    res *= prefix[i - 1];
                }
                if (i < n - 1) {
                    res *= suffix[i + 1];
                }
                result[i] = res;
            }

            return result;
        }
    }

}
