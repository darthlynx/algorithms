package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
public class DivideAStringIntoGroupsOfSizeK {

    // Time complexity: O(n)
    // Space complexity: O(m*k), where m = ceil(n / k) ~> O(n)
    class Solution {
        public String[] divideString(String s, int k, char fill) {
            int resSize = s.length() % k != 0 ? s.length() / k + 1 : s.length() / k;
            String[] res = new String[resSize];

            int i = 0;
            for (int j = 0; j < s.length();) {
                if (j + k > s.length()) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(s.substring(j));
                    while (builder.length() < k) {
                        builder.append(fill);
                    }
                    res[i] = builder.toString();
                } else {
                    String current = s.substring(j, j + k);
                    res[i] = current;
                }
                i++;
                j += k;
            }

            return res;
        }
    }
}
