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
			Integer ceilingOnLeft = tset.higher(arr[i]);
			if (ceilingOnLeft == null) {
				result.add(-1);
			} else {
				result.add(ceilingOnLeft);
			}
			tset.add(arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 8, 30, 15, 25, 12 };
		List<Integer> result = findCeiling(arr);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}
}
