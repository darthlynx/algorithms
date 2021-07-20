package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/repeated-substring-pattern/
public class RepeatedSubstringPattern {

    // Let's say we have s = `abab`
    // doubled = `abababab`
    // while looping through the s string we are trying to find the occurrence of it in the doubled string
    // literally, we are looking for the next substring:
    // `abababab`
    //    ^  ^
    // in our case it is `doubled.substring(2, 6)`

    public boolean repeatedSubstringPattern(String s) {

        // repeat the string twice. We will use a sliding window to find the repeatable s occurrence
        String doubled = s.repeat(2);

        int sLength = s.length();

        for (int i = 1; i < s.length(); i++) {
            if (s.equals(doubled.substring(i, i+sLength))) {
                return true;
            }
        }

        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        String doubled = s.repeat(2);
        // find the occurrence of the s starting from 1st index
        // we cannot use 0 or else we will find s itself
        int occurrenceIndex = doubled.indexOf(s, 1);

        // if found index equals to the length of the string, the s string does not have repeated pattern
        // e.g.
        // if we have s = `ab`, doubled = `abab`
        // occurrenceIndex == 2 which is pointing to the beginning of the s copy
        // `abab`
        //    ^
        // for s = `abab`, doubled = `abababab`
        // occurrenceIndex == 2. 2 < s.length(), so that we found the pattern
        // `abababab`
        //    ^

        return occurrenceIndex != s.length();
    }
}
