package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
public class MinimizedMaximumOfProductsDistributedToAnyStore {

    // Time complexity: O(N * logN)
    // Space complexity: O(1)
    class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            
            int max = Integer.MIN_VALUE;
            for (int q : quantities) {
                max = Math.max(max, q);
            }
    
            int good = 0;
            int bad = max + 1;
    
            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                
                // if good enough, we are trying to minimize the maximum,
                // so need to move the right pointer
                if (isGoodEnough(quantities, mid, n)) {
                    bad = mid;
                } else {
                    good = mid;
                }
            }
            
            return good + 1;
        }
    
        private boolean isGoodEnough(int[] quantities, int mid, int n) {
            int count = 0;
    
            for (int q : quantities) {
                int round = q % mid > 0 ? 1 : 0;
                count += q / mid + round;
            }
            return count <= n;
        }
    }
}
