package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lexicographical-numbers/
public class LexicographicalNumbers {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> result = new ArrayList<>();
    
            for (int i = 1; i < 10; i++) {
                dfs(i, n, result);
            }
    
            return result;
        }
    
        private void dfs(int node, int n, List<Integer> result) {
            if (node > n) {
                return;
            }
            result.add(node);
            for (int i = 0; i < 10; i++) {
                int num = node * 10 + i;
                if (num > n) {
                    break;
                }
                dfs(num, n, result);
            }
        }
    }
}
