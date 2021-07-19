package com.darthlynx.algorithms.leetcode;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {

    private final Map<Integer, List<String>> mapping = getIntToCharMapping();
    private String phoneDigits;
    private List<String> combinations;

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        phoneDigits = digits;
        backtracking(0, new StringBuilder());

        return combinations;
    }

    private void backtracking(int index, StringBuilder builder) {
        // length of combination should be equal to digits length
        if (builder.length() == phoneDigits.length()) {
            combinations.add(builder.toString());
            return;
        }

        // possible letters in current position
        List<String> letters = mapping.get(Integer.parseInt(String.valueOf(phoneDigits.charAt(index))));
        for (String s : letters) {
            // add current letter to fix the prefix
            builder.append(s);
            // use prefix to dive deeper
            backtracking(index+1, builder);
            // remove current letter before next iteration
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private Map<Integer, List<String>> getIntToCharMapping() {
        Map<Integer, List<String>> mapping = new HashMap<>();
        mapping.put(1, Collections.emptyList());
        mapping.put(2, List.of("a", "b", "c"));
        mapping.put(3, List.of("d", "e", "f"));
        mapping.put(4, List.of("g", "h", "i"));
        mapping.put(5, List.of("j", "k", "l"));
        mapping.put(6, List.of("m", "n", "o"));
        mapping.put(7, List.of("p", "q", "r", "s"));
        mapping.put(8, List.of("t", "u", "v"));
        mapping.put(9, List.of("w", "x", "y", "z"));

        return mapping;
    }

}
