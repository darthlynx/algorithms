package com.darthlynx.algorithms.strings;

// Given a string, determine whether any permutation of it is a palindrome.
// For example, `carrace` should return true, since it can be rearranged to form `racecar`,
// which is a palindrome. `daily` should return false, since there's no rearrangement that can form a palindrome.

public class DetermineThePalindrome {

    public boolean ifWordCanBeAPalindrome(String s) {

        StringBuilder result = new StringBuilder(s);

        char current;
        int left, right;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            left = result.indexOf(String.valueOf(current));
            right = result.lastIndexOf(String.valueOf(current));
            if (left >= 0 && right >= 0 && right != left) {
                deleteCharOccurrences(result, left, right);
            }
        }

        return result.length() <= 1;
    }

    private void deleteCharOccurrences(StringBuilder builder, int left, int right) {
        builder.deleteCharAt(right);
        builder.deleteCharAt(left);
    }

}
