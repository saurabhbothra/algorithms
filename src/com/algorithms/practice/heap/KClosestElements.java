package com.algorithms.practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

	// Given an array and two numbers x and k, we need to find k closest numbers to
	// x.

	// naive solution.
	public static List<Integer> findKClosestElementsNaive(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[arr.length];
		for (int i = 0; i < k; i++) {
			int minDiff = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < arr.length; j++) {
				if (!visited[j]) {
					int diff = Math.abs(arr[j] - x);
					if (diff < minDiff) {
						minDiff = diff;
						index = j;
					}
				}
			}
			visited[index] = true;
			result.add(arr[index]);
		}
		return result;
	}

	// efficient solution.
	public static List<Integer> findKClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((i1, i2) -> -Integer.compare(i1[0], i2[0]));
		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				int temp = Math.abs(arr[i] - x);
				if (temp < pq.peek()[0]) {
					pq.poll();
					pq.add(new Integer[] { temp, i });
				}
			} else {
				pq.add(new Integer[] { Math.abs(arr[i] - x), i });
			}
		}
		while (!pq.isEmpty()) {
			result.add(arr[pq.poll()[1]]);
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 15, 7, 3, 4 };
		int[] arr1 = { 100, 80, 10, 5, 70 };
		int[] arr2 = { 20, 40, 5, 100, 150 };
		List<Integer> result = findKClosestElementsNaive(arr2, 3, 100);
		Integer[] resultArr = result.toArray(new Integer[result.size()]);
		System.out.println("The k largest elements are: " + Arrays.toString(resultArr));
	}

}
