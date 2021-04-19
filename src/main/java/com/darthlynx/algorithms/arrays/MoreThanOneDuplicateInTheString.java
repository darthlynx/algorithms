package com.darthlynx.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MoreThanOneDuplicateInTheString {

    // given a string of letters
    // create a function, that will return true, if string has more than two repeated characters
    public static void main(String[] args) {

        String s1 = "aabbcc";
        String s2 = "aaabb";

        printResult(MoreThanOneDuplicateInTheString::isHasMoreThanOneDup, s1);
        printResult(MoreThanOneDuplicateInTheString::isHasMoreThanOneDup, s2);

        printResult(MoreThanOneDuplicateInTheString::hasMoreDups, s1);
        printResult(MoreThanOneDuplicateInTheString::hasMoreDups, s2);
    }

    static void printResult(Function<String,Boolean> func, String s) {
        long start = System.currentTimeMillis();
        System.out.println(func.apply(s));
        System.out.println("duration: " + (System.currentTimeMillis() - start));
    }


    static boolean isHasMoreThanOneDup(String s) {
        Map<Character, Integer> dups = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (dups.containsKey(ch)) {
                int value = dups.get(ch);
                if (value >= 2) {
                    return true;
                }
                dups.put(ch, value + 1);
            } else {
                dups.put(ch, 1);
            }
        }
        return false;
    }

    static boolean hasMoreDups(String s) {
        int[] presence = new int[255];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int dup = presence[ch];
            if (dup >= 2) {
                return true;
            } else {
                presence[ch] += 1;
            }
        }
        return false;
    }

}
