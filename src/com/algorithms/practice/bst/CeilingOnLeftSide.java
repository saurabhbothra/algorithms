package com.algorithms.practice.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CeilingOnLeftSide {

	// Given an array, for every element find ceiling of it on left side of the
	// array.

	// efficient solution.
	public static List<Integer> findCeiling(int[] arr) {
		List<Integer> result = new ArrayList<>();
		TreeSet<Integer> tset = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			Integer ceilingOnLeft = tset.ceiling(arr[i]);
			if (ceilingOnLeft == null) {
				result.add(-1);
			} else {
				result.add(ceilingOnLeft);
			}
			tset.add(arr[i]);
		}
		return result;
	}

	// naive solution.
	public static List<Integer> findCeilingNaive(int[] arr) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int ceiling = -1;
			for (int j = 0; j < i; j++) {
				int diff = arr[j] - arr[i];
				if (diff >= 0) {
					ceiling = (ceiling == -1) ? arr[j] : Math.min(arr[j], ceiling);
				}
			}
			result.add(ceiling);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 8, 30, 15, 25, 12 };
		int[] arr1 = { 6, 18, 4, 5 };
		List<Integer> result = findCeiling(arr1);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}
}
