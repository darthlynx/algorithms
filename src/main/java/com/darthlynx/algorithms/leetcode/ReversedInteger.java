package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/reverse-integer/
public class ReversedInteger {

    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            result = result * 10 + pop;
            if (isOverflowed(result)) {
                return 0;
            }
        }

        return (int) result;
    }

    private boolean isOverflowed(long result) {
        return result < Integer.MIN_VALUE || result >= Integer.MAX_VALUE;
    }

}
