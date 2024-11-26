package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/sliding-puzzle/
public class SlidingPuzzle {

    // Time complexity: O((m*n)! * (m*n))
    // Space complexity: O((m*n)!)
    class Solution {

        private static final String TARGET = "123450";
    
        // if we transform 2D array into 1D array, map below will represent possible directions for movement 
        // for the '0' tile
        // for example:
        // [[1,2,3],
        //  [4,0,5]]
        // will be transformed into [1,2,3,4,0,5]
        // therefore, if 0 is located in position 4 in 1D array, it could only go to positions 1 (up), 3(left) and 5(right)
        private final int[][] directions = {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 3, 5, 1 },
            { 4, 2 },
        };
    
        public int slidingPuzzle(int[][] board) {
            Set<String> visited = new HashSet<>();
            String initial = toString(board);
            if (TARGET.equals(initial)) {
                return 0;
            }
    
            int moves = 0;
            Queue<String> q = new LinkedList<>();
            q.add(initial);
            visited.add(initial);
    
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String currentState = q.poll();
    
                    if (TARGET.equals(currentState)) {
                        return moves;
                    }
    
                    int zeroPosition = currentState.indexOf('0');
                    for (int newPosition : directions[zeroPosition]) {
                        String newState = swap(currentState, zeroPosition, newPosition);
    
                        // skip visited state
                        if (visited.contains(newState)) {
                            continue;
                        }
    
                        visited.add(newState);
                        q.add(newState);
                    }
                }
                moves++;
            }
    
            return -1;
        }
    
        private String swap(String currentState, int zeroPosition, int newPosition) {
            char[] state = currentState.toCharArray();
            state[zeroPosition] = state[newPosition];
            state[newPosition] = '0';
            return new String(state);
        }
    
        private String toString(int[][] board) {
            StringBuilder sb = new StringBuilder();
    
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]); 
                }
            }
    
            return sb.toString();
        }
    }

}
