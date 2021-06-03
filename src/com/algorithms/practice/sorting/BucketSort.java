package com.algorithms.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	// Implement bucket sort algorithm.

	// efficient solution.
	public static void bucketSort(int[] arr, int k) {
		List<List<Integer>> buckets = new ArrayList<>();
		int maxValue = Arrays.stream(arr).max().getAsInt();
		maxValue++;
		for (int i = 0; i < k; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < arr.length; i++) {
			int index = (k * arr[i]) / maxValue;
			buckets.get(index).add(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			Collections.sort(buckets.get(i));
		}
		int index = 0;
		for (List<Integer> bucket : buckets) {
			for (int element : bucket) {
				arr[index] = element;
				index++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 80, 10, 85, 75, 99, 18 };
		int[] arr1 = { 20, 80, 40, 30, 70 };
		bucketSort(arr, 5);
		bucketSort(arr1, 4);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
		System.out.println("The array after sorting is: " + Arrays.toString(arr1));
	}

}
