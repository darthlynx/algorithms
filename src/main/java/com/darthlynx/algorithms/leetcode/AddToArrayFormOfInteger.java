package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/add-to-array-form-of-integer/
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {

        int numPointer = num != null ? num.length - 1 : 0;
        int tmp = k;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (numPointer >= 0 || tmp > 0) {
            int sum = carry + tmp % 10;
            if (num != null && numPointer >= 0) {
                sum += num[numPointer];
            }
            numPointer--;
            carry = sum / 10;
            tmp = tmp / 10;

            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return stringToListOfIntegers(result.reverse().toString());
    }

    private List<Integer> stringToListOfIntegers(String resultString) {
        List<Integer> resultList = new ArrayList<>();
        for (char elem : resultString.toCharArray()) {
            resultList.add(elem - '0');
        }
        return resultList;
    }
}
