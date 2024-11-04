package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/string-compression-iii/
public class StringCompressionIII {

    // Time complexity: O(n)
    // Space complexity: O(n), where n - number of chars in the word
    class Solution {
        public String compressedString(String word) {
            StringBuilder comp = new StringBuilder();
    
            int counter = 1;
            int currChar = word.charAt(0);
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) != currChar || counter == 9) {
                    comp.append(counter);
                    comp.append((char) currChar);
                    counter = 1;
                    currChar = word.charAt(i);
                } else {
                    counter++;
                }
            }
            comp.append(counter);
            comp.append((char) currChar);
    
            return comp.toString();
        }
    }

}
