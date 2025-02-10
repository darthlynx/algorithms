package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/clear-digits/
public class ClearDigits {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public String clearDigits(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch) &&
                        (!stack.isEmpty() && !Character.isDigit(stack.peek()))) {
                    stack.pop();
                } else {
                    stack.add(ch);
                }
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }

            return builder.reverse().toString();
        }
    }
}
