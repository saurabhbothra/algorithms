package com.algorithms.practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {

	// Given an unsorted array and a number k, we need to print k largest elements.

	// efficient solution.
	public static List<Integer> findKLargestElements(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				if (arr[i] > pq.peek()) {
					pq.poll();
					pq.add(arr[i]);
				}
			} else {
				pq.add(arr[i]);
			}
		}

		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 15, 10, 20, 8 };
		List<Integer> result = findKLargestElements(arr, 2);
		Integer[] resultArr = result.toArray(new Integer[result.size()]);
		System.out.println("The k largest elements are: " + Arrays.toString(resultArr));
	}

}
