package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-unique-binary-string/
public class FindUniqueBinaryString {

    // Time complexity: O(2^n)
    // Space complexity: O(2^n)
    class Solution {

        public String findDifferentBinaryString(String[] nums) {
            int n = nums[0].length();
            Set<String> numSet = new HashSet<>();
            for (String num : nums) {
                numSet.add(num);
            }
            return generate("", n, numSet);
        }
    
        private String generate(String current, int n, Set<String> numSet) {
            if (current.length() == n) {
                if (!numSet.contains(current)) {
                    return current;
                }
                return "";
            } 
    
            String res = generate(current + '0', n, numSet);
            if (res.length() > 0) {
                return res;
            }
    
            return generate(current + '1', n, numSet);
        }
    }

    // Time complexity: O(2^n)
    // Space complexity: O(2^n)
    class Solution2 {
        private String good = "";

        public String findDifferentBinaryString(String[] nums) {
            int n = nums[0].length();

            Set<String> numSet = new HashSet<>();
            for (String num : nums) {
                numSet.add(num);
            }
            generate("", n, numSet);

            return good;
        }

        private void generate(String current, int n, Set<String> numSet) {
            if (current.length() == n) {
                if (!numSet.contains(current)) {
                    good = current;
                }
                return;
            }

            String next = current + '0';
            generate(next, n, numSet);
            next = current + '1';
            generate(next, n, numSet);
        }
    }
}
