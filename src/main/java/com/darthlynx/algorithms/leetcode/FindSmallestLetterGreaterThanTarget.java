package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class FindSmallestLetterGreaterThanTarget {

    // binary search approach
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        int mid;
        while (left <= right) {
            mid = left + (right - left)/2;

            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1; // left pointer will be always 1 step bigger, because we are looking for
                                // the smallest char that is larger than target
            }
        }

        // use % division to cover the letters wrap around clause
        // e.g.
        // if letters.length = 4 and left = 3
        // then 3 % 4 = 3
        // if left = 5 (greater than letters.length)
        // then 5 % 4 = 1 (will point to the 1st element to bypass overflow)
        return letters[left % letters.length];
    }
}
