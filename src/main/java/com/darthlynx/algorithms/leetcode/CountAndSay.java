package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-and-say/
public class CountAndSay {

    // Time complexity: O(2^n)
    // Space complexity: O(2^n)
    class Solution {
        public String countAndSay(int n) {
            String result = "1";
            for (int i = 2; i <= n; i++) {
                result = countAndSayHelper(result);
            }
            return result;
        }

        private String countAndSayHelper(String s) {
            StringBuilder builder = new StringBuilder();
            int count = 1;
            char digit = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current != digit) {
                    builder.append(count).append(digit);
                    count = 1;
                    digit = current;
                } else {
                    count++;
                }
            }
            builder.append(count).append(digit);
            return builder.toString();
        }
    }
}
