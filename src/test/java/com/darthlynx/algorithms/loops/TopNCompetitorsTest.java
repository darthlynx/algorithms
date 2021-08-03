package com.darthlynx.algorithms.loops;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TopNCompetitorsTest {

    private TopNCompetitors test = new TopNCompetitors();

    @Test
    public void test1() {
        int numCompetitors = 6;
        int topNCompetitors = 2;
        List<String> competitors = List.of("newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular");
        int numReviews = 6;

        List<String> reviews = List.of(
                "newshop is providing good services in the city; everyone should use newshop",
                "best services by newshop",
                "fashionbeats has great services in the city",
                "I am proud to have fashionbeats",
                "mymarket has awesome services",
                "Thanks Newshop for the quick delivery");

        List<String> expectedResult = List.of("newshop", "fashionbeats");

        List<String> actualResult = test.getTopNCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);

        assertEquals(expectedResult, actualResult);
    }

}