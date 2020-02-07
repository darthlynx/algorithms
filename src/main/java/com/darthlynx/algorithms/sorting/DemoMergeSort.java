package com.darthlynx.algorithms.sorting;

import java.util.Arrays;

public class DemoMergeSort {

	public static void mergeSort(int arr[], int start, int end) {
        if (end < start) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergeSort(arr, start, middle - 1);
        mergeSort(arr, middle + 1, end);

        int[] buf1 = new int[middle];
        int[] buf2 = new int[end - middle];

        for (int i = 0; i < middle -1; i++) {
            buf1[i] = arr[i];
        }
        int j = 0;
        for (int i = middle; i < end -1; i++) {
            buf2[j] = arr[i];
            ++j;
        }

        arr = merge2arrays(buf1, buf2);
//        System.out.println(Arrays.toString(arr));
    }

    private static int[] merge2arrays(int[] buf1, int[] buf2) {
        int resultSize = buf1.length + buf2.length;

        int[] result = new int[resultSize ];

        int index = 0;
        int i = 0;
        int j = 0;

        while (i < buf1.length || j < buf2.length || index < result.length) {
            if (i >= buf1.length) {
                result[index++] = buf2[j++];
            } else if (j >= buf2.length - 1) {
                result[index++] = buf1[i++];
            } else if (buf1[i] >= buf2[j]) {
                result[index++] = buf2[j++];
            } else {
                result[index++] = buf1[i++];
            }
        }


        return result;
    }
}
