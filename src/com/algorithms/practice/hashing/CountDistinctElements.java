package com.algorithms.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {

	// Given an array of numbers, find count of distinct elements.

	// efficient solution.
	public static int countDistinctElements(int[] arr) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);
		}
		return s.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 15, 12, 13, 12, 13, 13, 18 };
		int[] arr1 = { 10, 10, 10 };
		int[] arr2 = { 10, 11, 12 };
		System.out.println("The count of distinct elements are: " + countDistinctElements(arr));
		System.out.println("The count of distinct elements are: " + countDistinctElements(arr1));
		System.out.println("The count of distinct elements are: " + countDistinctElements(arr2));
	}

}
