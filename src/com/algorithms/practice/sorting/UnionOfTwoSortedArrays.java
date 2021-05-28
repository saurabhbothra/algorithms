package com.algorithms.practice.sorting;

public class UnionOfTwoSortedArrays {

	// Given two sorted arrays, we need to print union of the two sorted arrays.

	// efficient solution.
	public static void union(int[] a, int[] b) {
		int pointer1 = 0;
		int pointer2 = 0;
		while (pointer1 < a.length && pointer2 < b.length) {
			if (pointer1 != 0 && a[pointer1] == a[pointer1 - 1]) {
				pointer1++;
				continue;
			}
			if (pointer2 != 0 && b[pointer2] == b[pointer2 - 1]) {
				pointer2++;
				continue;
			}
			if (a[pointer1] < b[pointer2]) {
				System.out.print(a[pointer1] + " ");
				pointer1++;
			} else if (b[pointer2] < a[pointer1]) {
				System.out.print(b[pointer2] + " ");
				pointer2++;
			} else {
				System.out.print(a[pointer1] + " ");
				pointer1++;
				pointer2++;
			}
		}

		while (pointer1 < a.length) {
			if (pointer1 != 0 && a[pointer1] == a[pointer1 - 1]) {
				pointer1++;
				continue;
			}
			System.out.print(a[pointer1] + " ");
			pointer1++;
		}

		while (pointer2 < b.length) {
			if (pointer2 != 0 && b[pointer2] == b[pointer2 - 1]) {
				pointer2++;
				continue;
			}
			System.out.print(b[pointer2] + " ");
			pointer2++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 5, 8 };
		int[] b = { 2, 8, 9, 10, 15 };

		int[] a1 = { 2, 3, 3, 3, 4, 4 };
		int[] b1 = { 4, 4 };
		System.out.println("The union elements are:");
		union(a, b);
		System.out.println();
		System.out.println("The union elements are:");
		union(a1, b1);
	}

}
