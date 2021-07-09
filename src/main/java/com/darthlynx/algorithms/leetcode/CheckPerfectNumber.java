package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/perfect-number/
public class CheckPerfectNumber {

    // time complexity - O (n^1/2)
    public boolean checkPerfectNumber(int num) {

        if (num < 0) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i;

                if (i*i != num) {
                    sum += num / i;
                }
            }
        }

        // while considering 1 as such a factor, num will also be considered as the other factor.
        // Thus, we need to subtract num from the sum
        return sum - num == num;
    }
}
