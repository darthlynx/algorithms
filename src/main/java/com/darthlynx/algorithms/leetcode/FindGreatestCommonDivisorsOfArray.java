package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class FindGreatestCommonDivisorsOfArray {

    class Solution {
        public int findGCD(int[] nums) {
    
            int small = Integer.MAX_VALUE;
            int large = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num > large) {
                    large = num;
                }
                if (num < small) {
                    small = num;
                }
            }
    
            return gcd(small, large);
        }
    
        private int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }
    }
}