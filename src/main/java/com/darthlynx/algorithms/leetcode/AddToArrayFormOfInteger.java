package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/add-to-array-form-of-integer/
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {

        int numPointer = num != null ? num.length - 1 : 0;
        int tmp = k;
        int carry = 0;

        List<Integer> result = new ArrayList<>();
        while (numPointer >= 0 || tmp > 0) {
            int sum = carry + tmp % 10;
            if (num != null && numPointer >= 0) {
                sum += num[numPointer];
            }
            numPointer--;
            carry = sum / 10;
            tmp = tmp / 10;

            result.add(sum % 10);
        }

        if (carry > 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        return result;
    }

}
