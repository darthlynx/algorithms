package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/parsing-a-boolean-expression/
public class ParsingABooleanExpression {

    // Space complexity: O(n)
    // Time complexity: O(n)
    class Solution {
        public boolean parseBoolExpr(String expression) {
            Stack<Character> stack = new Stack<>();

            for (char ch : expression.toCharArray()) {
                if (ch == ')') {
                    // process elements inside ()
                    List<Character> chars = new ArrayList<>();
                    while (stack.peek() != '(') {
                        chars.add(stack.pop());
                    }

                    stack.pop(); // remove '('
                    char operator = stack.pop(); // poll operator (!, &, |)

                    char res = subExpression(operator, chars);
                    stack.add(res);
                } else if (ch != ',') {
                    stack.add(ch);
                }
            }

            return stack.peek() == 't';
        }

        private char subExpression(char operator, List<Character> operands) {
            // negate the expression (operands may contain only one element)
            if (operator == '!') {
                return operands.get(0) == 't' ? 'f' : 't';
            }

            // if at least one parameter equals false, result will be false
            if (operator == '&') {
                for (char op : operands) {
                    if (op == 'f') {
                        return 'f';
                    }
                }
                return 't';
            }

            // if at least one parameter equals to true, result will be true
            if (operator == '|') {
                for (char op : operands) {
                    if (op == 't') {
                        return 't';
                    }
                }
                return 'f';
            }

            return 'f'; // shouldn't reach this level
        }
    }
}
