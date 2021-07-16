package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        Map<String,String> mapping = getMapping();

        StringBuilder result = new StringBuilder();

        char numberSign = '#';
        int index = s.length()-1;
        int shift;
        while (index >= 0) {
            char currentChar = s.charAt(index);
            if (currentChar == numberSign) {
                result.append(mapping.get(s.substring(index - 2, index+1)));
                shift = 3;
            } else {
                result.append(mapping.get(Character.toString(currentChar)));
                shift = 1;
            }

            index -= shift;
        }



        return result.reverse().toString();
    }

    // TODO: replace mapping with in-place calculation.
    //  It should take less memory and work faster (no need to use additional loop)
    private Map<String,String> getMapping() {
        Map<String,String> letters = new HashMap<>();

        char startLetter = 'a' - 1;
        for (int i = 1; i <= 26; i++) {
            String key = i > 9 ? i + "#" : Integer.toString(i);
            letters.put(key, Character.toString(startLetter + i));
        }

        return letters;
    }
}
