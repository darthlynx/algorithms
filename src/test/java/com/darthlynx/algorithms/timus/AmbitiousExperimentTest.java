package com.darthlynx.algorithms.timus;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AmbitiousExperimentTest {

    @Test
    public void testParticlesDivisorsGeneration() {
        AmbitiousExperiment experiment = new AmbitiousExperiment();
        int n = 6;

        List<Integer> expectedDivisorsForThree = List.of(1, 3);
        List<Integer> expectedDivisorsForFour = List.of(1, 2, 4);
        List<Integer> expectedDivisorsForSix = List.of(1, 2, 3, 6);

        List<Integer>[] result = experiment.calculateParticlesDivisors(n);
        for(int i = 0; i < result.length; i++) {
            System.out.printf("%d %s\n", i, result[i]);
        }

        assertEquals(expectedDivisorsForThree, result[3]);
        assertEquals(expectedDivisorsForFour, result[4]);
        assertEquals(expectedDivisorsForSix, result[6]);
    }

}