package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/uncommon-words-from-two-sentences/
public class UncommonWordsFromTwoSentences {

    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map = new HashMap<>();
            List<String> result = new ArrayList<>();

            for (String s : s1.split(" ")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (String s : s2.split(" ")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result.add(entry.getKey());
                }
            }

            // why use new String[0]: https://shipilev.net/blog/2016/arrays-wisdom-ancients/
            return result.toArray(new String[0]);
        }
    }
}
