package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
public class RemoveAllOccurrencesOfASubstring {

    public String removeOccurrences(String s, String part) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));

            if (result.lastIndexOf(part) >= 0) {
                result.replace(result.lastIndexOf(part), result.length(), "");
            }
        }

        return result.toString();
    }
}
