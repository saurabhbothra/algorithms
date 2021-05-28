package com.algorithms.practice.sorting;

public class IntersectionOfTwoSortedArrays {

	// Given two sorted arrays, pick out the intersection elements from the two
	// arrays.

	// efficient solution.
	public static void intersection(int[] a, int[] b) {
		int pointer1 = 0;
		int pointer2 = 0;
		while (pointer1 < a.length && pointer2 < b.length) {
			if(pointer1 != 0 && a[pointer1] == a[pointer1 - 1]) {
				pointer1++;
				continue;
			}
			if (a[pointer1] == b[pointer2]) {
				System.out.print(a[pointer1] + " ");
				pointer1++;
				pointer2++;
			} else if (a[pointer1] < b[pointer2]) {
				pointer1++;
			} else {
				pointer2++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 5, 10, 10, 10, 15, 15, 20 };
		int[] b = { 5, 10, 10, 15, 30 };

		int[] a1 = { 1, 1, 3, 3, 3 };
		int[] b1 = { 1, 1, 1, 1, 3, 5, 7 };
		System.out.println("The intersection elements are:");
		intersection(a, b);
		System.out.println();
		System.out.println("The intersection elements are:");
		intersection(a1, b1);
	}

}
