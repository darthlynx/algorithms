package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/bitwise-xor-of-all-pairings/
public class BitwiseXOROfAllPairings {

    // Time complexity: O(n + m)
    // Space complexity: O(1)
    //
    // This solution is based on the XOR property
    // XOR is very much like multiplication
    // 
    // for current task we need to match all elements from nums1 = [a, b, c] and nums2 = [x, y]
    //
    // paring everything will be:
    // [a^x, a^y, b^x, b^y, c^x, c^y]
    //
    // to get the result we need to XOR all pairs:
    // (a^x) ^ (a^y) ^ (b^x) ^ (b^y) ^ (c^x) ^ (c^y)
    // which transforms into:
    // (a^b^c) ^ (a^b^c) ^ (x^y) ^ (x^y) ^ (x^y)
    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
    
            int nums1xor = 0;
            for (int num : nums1) {
                nums1xor ^= num;
            }
    
            int nums2xor = 0;
            for (int num : nums2) {
                nums2xor ^= num;
            }
    
            int xor = 0;
    
            for (int i = 0; i < m; i++) {
                xor ^= nums1xor;
            }
    
            for (int i = 0; i < n; i++) {
                xor ^= nums2xor;
            }
    
            return xor;
        }
    }

    // TIME LIMIT EXCEEDED
    // Time complexity: O(n * m)
    // Space complexity: O(1)
    class Solution2 {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int xor = 0;
    
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    xor ^= nums1[i] ^ nums2[j];
                }
            }
    
            return xor;
        }
    }
}
