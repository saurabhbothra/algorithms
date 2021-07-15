package com.algorithms.practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {

	// Given an array of n elements, where each element is at most k away from its
	// target position, you need to sort the array optimally.

	// efficient solution.
	public static List<Integer> nearlySorted(int arr[], int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
			if (i >= k) {
				int item = pq.poll();
				result.add(item);
			}
		}
		while (!pq.isEmpty()) {
			int item = pq.poll();
			result.add(item);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
		List<Integer> result = nearlySorted(arr, 3);
		Integer[] resultArr = result.toArray(new Integer[result.size()]);
		System.out.println("The sorted array is: " + Arrays.toString(resultArr));
	}
}
