package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/defuse-the-bomb/
public class DefuseTheBomb {

    // Time complexity: O(N*k)
    // Space complexity: O(N)
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            
            int[] res = new int[n];
    
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = i+1; j <= i + k; j++) {
                        sum += code[j % n];
                    }
                    res[i] = sum;
                } 
            } else if (k < 0) {
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = i-1; j >= i - Math.abs(k); j--) {
                        // to avoid getting negative indexes, we add n to the j
                        sum += code[(j + n) % n];
                    }
                    res[i] = sum;
                }
            }
    
            return res;
        }
    }

}
