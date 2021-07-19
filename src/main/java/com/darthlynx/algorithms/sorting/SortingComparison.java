package com.darthlynx.algorithms.sorting;

import java.util.List;

import com.darthlynx.algorithms.utils.Utils;

public class SortingComparison {

	public static void main(String[] args) {
		List<Integer> list = Utils.generateRandomList(5000, 0, 2000);
		System.out.println("Count of elements: " + list.size());
		
		long start = System.currentTimeMillis();
		QuickSort.quickSort(list);
		System.out.println("Quick sort:");
		Utils.printExecutionTime(start);
		
		start = System.currentTimeMillis();
		SelectionSort.selectionSort(list);
		System.out.println("Selection sort:");
		Utils.printExecutionTime(start);
		
		int[] array = list.stream().mapToInt(i -> i).toArray();
		start = System.currentTimeMillis();
		DemoMergeSort.mergeSort(array, 0, array.length - 1);
		System.out.println("Merge sort:");
		Utils.printExecutionTime(start);
		
		System.out.println("End");
	}
}
