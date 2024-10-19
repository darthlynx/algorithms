package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
public class FindKthBitInNthBinaryString {

    // brute force
    // Time and Space complexity: O(2^n)
    class Solution {
        public char findKthBit(int n, int k) {
            
            StringBuilder builder = new StringBuilder();
            builder.append('0');
    
            for (int i = 1; i < n; i++) {
                char[] prev = builder.toString().toCharArray();
                invert(prev);
                reverse(prev);
                builder.append('1');
                builder.append(prev);
            }
            // System.out.println(builder.toString());
    
            return builder.charAt(k-1);
        }
    
        private void reverse(char[] chars) {
            int left = 0;
            int right = chars.length-1;
    
            while (left < right) {
                char tmp = chars[right];
                chars[right] = chars[left];
                chars[left] = tmp;
                left++;
                right--;
            }
    
            // System.out.println("Reverse: " + new String(chars));
        }
    
        private void invert(char[] chars) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (('1' - chars[i]) + '0');
            }
            // System.out.println("Invert: " + new String(chars));
        }
    }

    // Simplified brute force
    // Space & time: O(2^n)
    class Solution2 {
        public char findKthBit(int n, int k) {
            
            StringBuilder builder = new StringBuilder();
            builder.append('0');
    
            for (int i = 1; i < n; i++) {
                builder.append('1');
    
                // invert S(i-1) and add in reversed order
                for (int j = builder.length() - 2; j >= 0; j--) {
                    char ch = builder.charAt(j) == '1' ? '0' : '1';
                    builder.append(ch);
                }
                
            }
            //System.out.println(builder.toString());
    
            return builder.charAt(k-1);
        }
    }

}
