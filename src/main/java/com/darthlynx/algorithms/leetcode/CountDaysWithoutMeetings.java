package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/count-days-without-meetings/
public class CountDaysWithoutMeetings {

    // TLE
    // Time complexity: O(N + M)
    // Space complexity: O(N)
    // where N = days, M = meetings.length
    class Solution1 {
        public int countDays(int days, int[][] meetings) {
            int[] diff = new int[days + 2];

            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];

                diff[start]++;
                diff[end + 1]--;
            }

            int count = 0;
            int sum = 0;
            for (int i = 1; i < diff.length - 1; i++) {
                sum += diff[i];
                if (sum == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    // Time complexity: O(M*logM)
    // Space complexity: O(1)
    class Solution2 {
        public int countDays(int days, int[][] meetings) {

            Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 0;
            int prevEnd = 0;

            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];

                if (start > prevEnd + 1) {
                    count += start - (prevEnd + 1);
                }

                prevEnd = Math.max(prevEnd, end);
            }

            if (prevEnd < days) {
                count += days - prevEnd;
            }

            return count;
        }
    }
}
