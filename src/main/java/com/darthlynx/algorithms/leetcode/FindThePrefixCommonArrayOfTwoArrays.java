package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
public class FindThePrefixCommonArrayOfTwoArrays {

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            int[] freq = new int[n+1];
            int[] res = new int[n];
    
            for (int i = 0; i < n; i++) {
                freq[A[i]]++;
                freq[B[i]]++;
                int curr = freq[A[i]] == 2 ? 1 : 0;
                if (A[i] != B[i]) {
                    curr += freq[B[i]] == 2 ? 1 : 0;
                }
                if (i > 0) {
                    curr += res[i - 1];
                }
                res[i] = curr;
            }

            return res;
        }
    }
}
