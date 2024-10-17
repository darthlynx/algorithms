package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-swap/
public class MaximumSwap {

    class Solution {
        public int maximumSwap(int num) {
            int max = Integer.MIN_VALUE;
            int maxIdx = 0;
            int minIdx = 0;
    
            char[] chars = Integer.toString(num).toCharArray();
    
            for (int i = 0; i < chars.length; i++) {
                int n = chars[i] - '0';
                for (int j = chars.length-1; j > i; j--) {
                    int m = chars[j] - '0';
                    if (m > n && m > max) {
                        max = m;
                        maxIdx = j;
                        minIdx = i;
                    }
                }
            }
            
            if (max > 0) {
                chars[maxIdx] = chars[minIdx];
                chars[minIdx] = (char) (max + '0');
            }
    
            return Integer.valueOf(new String(chars));
        }
    }

}
