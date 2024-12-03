package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/adding-spaces-to-a-string/
public class AddingSpacesToAString {

    // Time complexity: O(n + m), where n = s.length(), m = spaces.length
    // Space complexity: O(n + m)
    class Solution1 {
        public String addSpaces(String s, int[] spaces) {
            Set<Integer> set = new HashSet<>();
            for (int space : spaces) {
                set.add(space);
            }
    
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(i)) {
                    sb.append(' ');
                }
                sb.append(s.charAt(i));
            }
    
            return sb.toString();
        }
    }

    // Time complexity: O(n + m), where n = s.length(), m = spaces.length
    // Space complexity: O(n + m) 
    class Solution2 {
        public String addSpaces(String s, int[] spaces) {
            int n = s.length();
            int m = spaces.length;
            
            int spaceIdx = 0;
    
            StringBuilder sb = new StringBuilder();
    
            for (int stringIdx = 0; stringIdx < n; stringIdx++) {
                if (spaceIdx < m && stringIdx == spaces[spaceIdx]) {
                    sb.append(' ');
                    spaceIdx++;
                }
                sb.append(s.charAt(stringIdx));
            }
    
            return sb.toString();
        }
    }
}
