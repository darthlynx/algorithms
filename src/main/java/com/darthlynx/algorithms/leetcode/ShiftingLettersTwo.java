package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/shifting-letters-ii/
public class ShiftingLettersTwo {

    // Time complexity: O(n + m)
    // Space complexity: O(n)
    // where n = s.length(); m = shifts.length
    class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int n = s.length();
            char[] chars = s.toCharArray();
    
            // we use difference array approach here
            int[] diff = new int[n];
            for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int direction = shift[2];
    
                if (direction == 1) { // move forward
                    diff[start]++;
                    if (end + 1 < n) {
                        diff[end + 1]--;
                    }
                } else { // move backward
                    diff[start]--;
                    if (end + 1 < n) {
                        diff[end + 1]++;
                    }
                }
            }
            
            int cumulativeShifts = 0;
            for (int i = 0; i < n; i++) {
                cumulativeShifts = (cumulativeShifts + diff[i]) % 26;
    
                if (cumulativeShifts < 0) {
                    cumulativeShifts += 26; // ensure non-negative shifts
                }
    
                chars[i] = (char) ('a' + (chars[i] - 'a' + cumulativeShifts) % 26);
            }
    
            return new String(chars);
        }
    }
}
