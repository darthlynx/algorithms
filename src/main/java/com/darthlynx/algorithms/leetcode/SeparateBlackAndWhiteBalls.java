package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/separate-black-and-white-balls/
public class SeparateBlackAndWhiteBalls {

    class Solution {

        public long minimumSteps(String s) {
            long countSwaps = 0;
            long blackCount = 0;
    
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') { // ball is white
                    // to swap all black balls to the right
                    // we need swap white ball to the left the same number of times
                    countSwaps += blackCount; 
                } else {
                    blackCount++;
                }
            }
    
            return countSwaps;
        }
    }

    class Solution2 {

        public long minimumSteps(String s) {
            long countSwaps = 0;
            int whitePosition = 0;
    
            for (int currPosition = 0; currPosition < s.length(); currPosition++) {
                if (s.charAt(currPosition) == '0') { // ball is white
                    // calculate the number of swaps required
                    // to move to the most left available position
                    countSwaps += currPosition - whitePosition;
                    whitePosition++;
                }
            }
    
            return countSwaps;
        }
    }

}
