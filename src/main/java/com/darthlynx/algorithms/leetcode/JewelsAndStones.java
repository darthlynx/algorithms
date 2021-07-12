package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

    // time complexity - O(n+m)
    // space complexity - O(n), where n - number of chars in jewels
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        int result = 0;

        for (char ch : jewels.toCharArray()) {
            jewelsSet.add(ch);
        }

        for (char ch : stones.toCharArray()) {
            if (jewelsSet.contains(ch)) {
                result++;
            }
        }

        return result;
    }

    // time complexity - O(n*m)
    // space complexity - O(1)
    public int numJewelsInStones2(String jewels, String stones) {

        int result = 0;

        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    result++;
                }
            }
        }
        return result;
    }
}
