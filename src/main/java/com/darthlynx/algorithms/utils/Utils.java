package com.darthlynx.algorithms.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utils {

    public static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size - 1; i++) {
            array[i] = i;
        }
        return array;
    }

    public static Integer[] generateRandomArray(int size, int min, int max) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.valueOf((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return array;
    }

    public static List<Integer> generateRandomList(int size, int min, int max) {
        return Arrays.asList(generateRandomArray(size, min, max));
    }

    public static void printArray(int[] array) {
        Stream.of(array).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);
    }

    public static <T> void printList(List<T> list) {
        list.forEach(System.out::println);
    }

    public static void printExecutionTime(long start) {
        long current = System.currentTimeMillis();
        System.out.println("Time, ms: " + (current - start));
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
