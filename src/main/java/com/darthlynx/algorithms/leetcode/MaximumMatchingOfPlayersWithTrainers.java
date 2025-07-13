package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
public class MaximumMatchingOfPlayersWithTrainers {

    // Time complexity: O(N*logN + M*logM)
    // Space complexity: O(1)
    // where N = players.length; M = trainers.length
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int i = players.length - 1;
            int j = trainers.length - 1;

            int pair = 0;
            while (i >= 0 && j >= 0) {
                if (players[i] <= trainers[j]) {
                    pair++;
                    i--;
                    j--;
                } else { // player's ability is bigger than trainers, so skipping him
                    i--;
                }
            }

            return pair;
        }
    }
}
