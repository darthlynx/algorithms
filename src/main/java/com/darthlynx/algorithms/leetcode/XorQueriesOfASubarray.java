package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/xor-queries-of-a-subarray/description/
public class XorQueriesOfASubarray {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] prefixXOR = new int[arr.length + 1];
            prefixXOR[0] = arr[0];
            for (int i = 0; i < arr.length; i++) {
                prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
            }

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = prefixXOR[queries[i][0]] ^ prefixXOR[queries[i][1] + 1];
            }

            return res;
        }
    }
}
