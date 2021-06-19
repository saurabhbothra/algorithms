package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class NextGreaterElement {

	// Given an array of integers, find next greater element
	// (position wise closest and on right side) for every array element.

	// efficient solution.
	public static void nextGreaterElement(int[] arr) {
		if (arr.length == 0) {
			System.out.print("Array is empty.");
			return;
		}
		ArrayDeque<Integer> st = new ArrayDeque<>();
		ArrayDeque<Integer> result = new ArrayDeque<>();
		st.push(arr[arr.length - 1]);
		result.push(-1);
		for (int i = arr.length - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() < arr[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				result.push(-1);
			} else {
				result.push(st.peek());
			}
			st.push(arr[i]);
		}
		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
		int[] arr1 = { 10, 15, 20, 25 };
		int[] arr2 = { 25, 20, 15, 10 };
		System.out.println("The previous greater element for every element is:");
		nextGreaterElement(arr);
		System.out.println();
		nextGreaterElement(arr1);
		System.out.println();
		nextGreaterElement(arr2);
		System.out.println();
	}

}
