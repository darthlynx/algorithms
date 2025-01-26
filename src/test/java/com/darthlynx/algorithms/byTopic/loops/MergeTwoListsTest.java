package com.darthlynx.algorithms.bytopic.loops;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MergeTwoListsTest {

    private MergeTwoLists test = new MergeTwoLists();

    @Test
    public void test1() {
        List<Integer> l1 = List.of(1, 2, 2, 5, 6, 10);
        List<Integer> l2 = List.of(3, 4, 7, 8, 11, 12, 13);

        List<Integer> expectedResult = List.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13);

        List<Integer> actualResult = test.merge(l1, l2);

        assertEquals(expectedResult, actualResult);
    }

}