package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/find-champion-ii/
public class FindChampionII {

    // Time complexity: O(v + e)
    // Space complexity: O(v)
    class Solution {
        public int findChampion(int n, int[][] edges) {
            
            int[] indegree = new int[n];
    
            for (int[] edge : edges) {
                indegree[edge[1]]++;
            }
            
            // winner is the node which is unique and has indegree == 0
            int winner = -1;
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    if (winner < 0) {
                        winner = i;
                    } else {
                        return -1;
                    }
                }
            }
    
            return winner;
        }
    }

}
