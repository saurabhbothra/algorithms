package com.algorithms.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfArrayElements {

	// Given an array of integers, print frequencies of all elements in the array.

	// naive solution.
	public static void printFrequenciesNaive(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					count = count + 1;
				}
			}
			System.out.println(arr[i] + " " + count);
		}
	}

	// efficient solution.
	public static void printFrequencies(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (countMap.containsKey(arr[i])) {
				countMap.put(arr[i], countMap.get(arr[i]) + 1);
			} else {
				countMap.put(arr[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 12, 10, 15, 10, 20, 12, 12 };
		int[] arr1 = { 10, 10, 10, 10 };
		int[] arr2 = { 10, 20 };
		System.out.println("The frequencies are: ");
		printFrequencies(arr);
		System.out.println();
		printFrequencies(arr1);
		System.out.println();
		printFrequencies(arr2);
	}

}
