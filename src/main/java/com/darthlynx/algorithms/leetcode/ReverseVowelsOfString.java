package com.darthlynx.algorithms.leetcode;


import java.util.Set;

// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowelsOfString {

    private final Set<Character> vowels = getVowels();

    public String reverseVowels(String s) {

        char[] string = s.toCharArray();

        int left = 0;
        int right = string.length-1;
        char lch, rch;

        while (left <= right) {
            lch = string[left];

            if (isVowel(lch)) {
                rch = string[right];
                if (isVowel(rch)) {
                    swap(string, left, right);
                    right--;
                    left++;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }

        return String.valueOf(string);
    }

    private boolean isVowel(char ch) {
        return vowels.contains(ch);
    }

    private void swap(char[] string, int left, int right) {
        char temp = string[left];
        string[left] = string[right];
        string[right] = temp;
    }

    private Set<Character> getVowels() {
        return Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    }
}
