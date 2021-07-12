package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberTheStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0)  {
                // bitwise operation so much faster than simple division
                num = num >> 1;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
