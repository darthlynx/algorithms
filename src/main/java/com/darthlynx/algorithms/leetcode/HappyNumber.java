package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {

    // Time complexity: O(logN) ~> O(1) due to the limited number of unique numbers
    // Space complexity: O(logN) ~> O(1) for the same reason
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> visited = new HashSet<>();
            while (n != 1) {
                if (visited.contains(n)) {
                    return false;
                }
                visited.add(n);
                n = getSum(n);
            }
            return true;
        }

        private int getSum(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            return sum;
        }
    }

    // Floyd's cycle detection algo ("Tortoise and Hare" method)
    // Time complexity: O(logN) ~> O(1)
    // Space complexity: O(1)
    class Solution2 {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = getSum(n);

            while (n != 1 && slow != fast) {
                slow = getSum(slow);
                fast = getSum(getSum(fast));
            }

            return fast == 1;
        }

        private int getSum(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            return sum;
        }
    }
}
