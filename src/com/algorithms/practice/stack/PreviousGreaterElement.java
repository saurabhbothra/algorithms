package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class PreviousGreaterElement {

	// Given an array of distinct integers, find closest (position wise) greater
	// element on left of every element. If there is no greater element on left,
	// print -1.

	// efficient solution.
	public static void prevGreaterElement(int[] arr) {
		if (arr.length == 0) {
			System.out.print("Array is empty.");
			return;
		}
		ArrayDeque<Integer> st = new ArrayDeque<>();
		System.out.print(-1 + " ");
		st.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			while (!st.isEmpty() && st.peek() < arr[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				System.out.print(-1 + " ");
			} else {
				System.out.print(st.peek() + " ");
			}
			st.push(arr[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 15, 10, 18, 12, 4, 6, 2, 8 };
		int[] arr1 = { 8, 10, 12 };
		int[] arr2 = { 12, 10, 8 };
		System.out.println("The previous greater element for every element is:");
		prevGreaterElement(arr);
		System.out.println();
		prevGreaterElement(arr1);
		System.out.println();
		prevGreaterElement(arr2);
		System.out.println();
	}

}
