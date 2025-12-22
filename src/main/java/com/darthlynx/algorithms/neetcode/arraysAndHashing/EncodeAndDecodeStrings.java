package com.darthlynx.algorithms.neetcode.arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode/question
public class EncodeAndDecodeStrings {

    class Solution {
        public static final char DELIMITER = '|';

        // Time complexity: O(n)
        // Space complexity: O(n)
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (String s : strs) {
                builder.append(s.length())
                        .append(DELIMITER)
                        .append(s);
            }
            return builder.toString();
        }

        // Time complexity: O(n)
        // Space complexity: O(n)
        public List<String> decode(String str) {
            List<String> result = new ArrayList<>();

            int index = 0;
            while (index < str.length()) {
                int len = 0;
                while (str.charAt(index) != DELIMITER) {
                    len = len * 10 + (str.charAt(index) - '0');
                    index++;
                }
                result.add(str.substring(index + 1, index + len + 1));
                index = index + len + 1;
            }
            return result;
        }
    }

}
