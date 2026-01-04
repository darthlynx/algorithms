package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/four-divisors/
public class FourDivisors {

    // Time complexity: O(n * sqrt(k)), where n is the length of nums and k is the maximum number in nums
    // Space complexity: O(1)
    class Solution {
        public int sumFourDivisors(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += getDivisorsSum(num);
            }
            return sum;
        }

        private int getDivisorsSum(int num) {
            int count = 0;
            int sum = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;
                    count++;
                    if (i != num / i) {
                        sum += num / i;
                        count++;
                    }
                    if (count > 4) {
                        return 0;
                    }
                }
            }
            if (count == 4) {
                return sum;
            }
            return 0;
        }
    }
}
