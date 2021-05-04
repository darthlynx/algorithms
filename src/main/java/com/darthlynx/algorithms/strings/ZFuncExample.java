package com.darthlynx.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZFuncExample {


    public static void main(String[] args) {

//        String s = "aaasdf";
//        System.out.println(Arrays.toString(zFunc(s)));

        String s1 = "EF";
        String s2 = "ABCDEFDEFEF";

        String res = String.join("#", s1, s2);

        System.out.println(Arrays.toString(zFunc(res)));

        System.out.println(Arrays.toString(zFunc("BAOBAOBAOBA")));

    }


    static int[] zFunc(String s) {
        int n = s.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i+z[i] < n && s.charAt(z[i]) == s.charAt(i+z[i])) {
                ++z[i];
            }
            if (i+z[i]-1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
