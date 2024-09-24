package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
public class FindTheLengthOfTheLongestCommonPrefix {

    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<Integer> set = new HashSet<>();
    
            for (int num : arr1) {
                while (num > 0) {
                    set.add(num);
                    num = num / 10;
                }
            }
    
            int prefixSize = 0;
    
            for (int num : arr2) {
                
                while (num > 0) {
                    if (set.contains(num)) {
                        prefixSize = Math.max(prefixSize, length(num));
                    }
                    num = num / 10;
                }
            }
    
            return prefixSize;
        }
    
        private int length(int num) {
            int length = 0;
            while (num > 0) {
                length++;
                num = num / 10;
            }
            return length;
        }
    }

}
