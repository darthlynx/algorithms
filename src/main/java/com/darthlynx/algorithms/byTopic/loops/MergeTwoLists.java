package com.darthlynx.algorithms.bytopic.loops;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>(l1.size() + l2.size());

        int p1 = 0, p2 = 0;

        // O(n+m)
        int e1, e2;
        while (p1 < l1.size() || p2 < l2.size()) {
            if (p1 < l1.size()) {
                e1 = l1.get(p1);
            } else {
                e1 = Integer.MAX_VALUE;
            }
            if (p2 < l2.size()) {
                e2 = l2.get(p2);
            } else {
                e2 = Integer.MAX_VALUE;
            }

            if (e1 <= e2) {
                result.add(e1);
                p1++;
            } else {
                result.add(e2);
                p2++;
            }
        }

        return result;
    }
}
