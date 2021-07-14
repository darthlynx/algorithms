package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-absolute-difference/
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        StringBuilder result = new StringBuilder();

        result.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (result.length() > 0 && result.charAt(result.length()-1) == s.charAt(i)) {
                result.deleteCharAt(result.length()-1);
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
