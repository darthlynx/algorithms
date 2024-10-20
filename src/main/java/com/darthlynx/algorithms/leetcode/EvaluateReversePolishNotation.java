package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
    
            for (String token : tokens) {
                int res = 0;
    
                if (token.equals("+")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    res = first + second;
                } else if (token.equals("-")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    res = first - second;
                } else if (token.equals("*")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    res = first * second;
                } else if (token.equals("/")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    res = first / second;
                } else {
                    res = Integer.parseInt(token);
                }
    
                stack.add(res);
            }
    
            return stack.peek();
        }
    
    }
}
