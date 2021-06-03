package com.algorithms.practice.sorting;

import java.util.Arrays;

public class CycleSort {

	// Implement cycle sort algorithm.

	// efficient solution.
	public static void cycleSort(int[] arr) {
		for (int cs = 0; cs < arr.length - 1; cs++) {
			int item = arr[cs];
			int pos = cs;
			for (int i = cs + 1; i < arr.length; i++) {
				if (arr[i] < item) {
					pos++;
				}
			}
			if (pos == cs) {
				continue;
			}
			while (item == arr[pos]) {
				pos++;
			}
			if (item != arr[pos]) {
				int temp = item;
				item = arr[pos];
				arr[pos] = temp;
			}
			while (pos != cs) {
				pos = cs;
				for (int i = cs + 1; i < arr.length; i++) {
					if (arr[i] < item) {
						pos++;
					}
				}
				while (item == arr[pos]) {
					pos++;
				}
				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 5, 60, 40, 10, 30 };
		int[] arr1 = { 20, 20, 20, 20, 10 };
		int[] arr2 = { 10, 10, 10, 10, 10 };
		cycleSort(arr);
		cycleSort(arr1);
		cycleSort(arr2);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
		System.out.println("The array after sorting is: " + Arrays.toString(arr1));
		System.out.println("The array after sorting is: " + Arrays.toString(arr2));
	}

}
