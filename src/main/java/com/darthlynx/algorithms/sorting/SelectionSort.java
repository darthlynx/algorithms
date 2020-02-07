package com.darthlynx.algorithms.sorting;

import java.util.LinkedList;
import java.util.List;

public class SelectionSort {
	
	public static List<Integer> selectionSort(List<Integer> list) {
		List<Integer> sorted = new LinkedList<>();
		LinkedList<Integer> initial = new LinkedList<>(list);
		for (int i = 0; i < initial.size(); i++) {
			int minIndex = getMin(initial);
			Integer min = initial.get(minIndex);
			sorted.add(min);
			initial.remove(minIndex);
		}
		return sorted;
	}
	
	private static int getMin(List<Integer> list) {
		int minIndex = 0;
		Integer minValue = list.get(minIndex);
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i) < minValue) {
				minValue = list.get(i);
				minIndex = i;
			}
		}
		return minIndex;
	}
	
}
