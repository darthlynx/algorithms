package com.darthlynx.algorithms.sorting;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.darthlynx.algorithms.utils.Utils;

public class QuickSort {

	public static List<Integer> quickSort(List<Integer> list) {
		if (list.size() <= 1) {
			return list;
		} else {
			Integer pivot = list.get(0);
			List<Integer> less = list.stream()
					.filter(e -> e.compareTo(pivot) < 0)
					.collect(Collectors.toList());
			List<Integer> greater = list.stream()
					.filter(e -> e.compareTo(pivot) > 0)
					.collect(Collectors.toList());
			
			return Stream.of(quickSort(less), List.of(pivot), quickSort(greater))
					.flatMap(Collection::stream)
					.collect(Collectors.toList());
		}
	}
}
