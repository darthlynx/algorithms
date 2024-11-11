package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

public class PrimeSubstructionOperation {

    class Solution {
        public boolean primeSubOperation(int[] nums) {
            // limit set in contstraints. Otherwise, could be found as max in nums
            int max = 1000; 
            boolean[] isPrime = identifyPrimes(max); 


            // Start by storing the currValue as 1, and the initial index as 0.
            int currValue = 1;
            int i = 0;
            while (i < nums.length) {
                // Store the difference needed to make nums[i] equal to currValue.
                int difference = nums[i] - currValue;

                // If difference is less than 0, then nums[i] is already less than
                // currValue. Return false in this case.
                if (difference < 0) {
                    return false;
                }

                // If the difference is prime or zero, then nums[i] can be made
                // equal to currValue.
                if (isPrime[difference] == true || difference == 0) {
                    i++;
                    currValue++;
                } else {
                    // Otherwise, try for the next currValue.
                    currValue++;
                }
            }
            return true;
        }

        private boolean[] identifyPrimes(int limit) {
            boolean[] isPrime = new boolean[limit + 1];
            Arrays.fill(isPrime, true);
            isPrime[1] = false; // 1 is not considered a prime number
            
            for (int i = 2; i * i <= limit; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= limit; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            return isPrime;
        }
    }
}
