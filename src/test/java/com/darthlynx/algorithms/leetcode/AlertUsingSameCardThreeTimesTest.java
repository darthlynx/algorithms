package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AlertUsingSameCardThreeTimesTest {

    private AlertUsingSameCardThreeTimes test = new AlertUsingSameCardThreeTimes();

    @Test
    public void test1() {
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};

        List<String> expectedResult = List.of("daniel");
        List<String> actualResult = test.alertNames(keyName, keyTime);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test2() {
        String[] keyName = {"alice","alice","alice","bob","bob","bob","bob"};
        String[] keyTime = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};

        List<String> expectedResult = List.of("bob");
        List<String> actualResult = test.alertNames(keyName, keyTime);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test3() {
        String[] keyName = {"john","john","john"};
        String[] keyTime = {"23:58","23:59","00:01"};

        List<String> expectedResult = Collections.emptyList();
        List<String> actualResult = test.alertNames(keyName, keyTime);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test4() {
        String[] keyName = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        String[] keyTime = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};

        List<String> expectedResult = List.of("clare","leslie");
        List<String> actualResult = test.alertNames(keyName, keyTime);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test5() {
        String[] keyName = {"b","b","b"};
        String[] keyTime = {"17:44","18:48","18:00"};

        List<String> expectedResult = Collections.emptyList();
        List<String> actualResult = test.alertNames(keyName, keyTime);

        assertEquals(expectedResult, actualResult);
    }
}