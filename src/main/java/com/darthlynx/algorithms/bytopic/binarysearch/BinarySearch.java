package com.darthlynx.algorithms.bytopic.binarysearch;

import com.darthlynx.algorithms.utils.Utils;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] array = Utils.generateArray(300);
		int searchFor = 254;
		System.out.println("Binary search:");
		System.out.println(binarySearch(array, searchFor));
		System.out.println("Linear search");
		System.out.println(linearSearch(array, searchFor));
	}
	
	private static int binarySearch(int[] array, int searchFor) {
		long begin = System.currentTimeMillis();
		int start = 0;
		int end = array.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int guess = array[mid];
			if (guess == searchFor) {
				Utils.printExecutionTime(begin);
				return mid;
			} else if (guess < searchFor) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			Utils.sleep(10);
		}
		
		System.out.println("Nothing found");
		Utils.printExecutionTime(begin);
		return -1;
	}
	
	private static int linearSearch(int[] array, int searchFor) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == searchFor) {
				Utils.printExecutionTime(start);
				return i;
			}
			Utils.sleep(10);
		}
		System.out.println("Nothing found");
		return -1;
	}

}
