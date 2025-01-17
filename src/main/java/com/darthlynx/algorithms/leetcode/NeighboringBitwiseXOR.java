package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/neighboring-bitwise-xor/
public class NeighboringBitwiseXOR {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        // Property of XOR: a ^ a = 0
        // therefore, if we have original array [a, b, c]
        // according to the task we had to do the next:
        // (a^b) ^ (b^c) ^ (c^a)
        // each element repeated twice, so they should transform into 0
        // so XOR sum should be 0 if array was valid
        public boolean doesValidArrayExist(int[] derived) {
            int xor = 0;
    
            for (int num : derived) {
                xor ^= num;
            }
    
            return xor == 0;
        }
    }
}
