package com.algorithms.practice.binarysearch;

public class AllocateMinimumPages {

	// Given an array in which element represents number of pages in a book.We are
	// also given a number k which represents number of students.

	// The k students are supposed to read all the books.
	// A student can read only contiguous books.
	// Minimize the maximum number of pages read by any student.

	// efficient solution.
	public static int allocatePagesEfficient(int[] arr, int k) {
		int totalSum = 0;
		int maxValue = Integer.MIN_VALUE;
		int result = Integer.MAX_VALUE;
		for (int num : arr) {
			totalSum += num;
			if (num > maxValue) {
				maxValue = num;
			}
		}
		int start = maxValue;
		int end = totalSum;
		while (start <= end) {
			int mid = (start + end) / 2;
			int actualK = findActualK(arr, mid);
			if (actualK <= k) {
				result = Math.min(result, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	// helper method to find k groups.
	private static int findActualK(int[] arr, int m) {
		int k = 0;
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum + arr[i] <= m) {
				sum = sum + arr[i];
			} else {
				k++;
				sum = arr[i];
			}
		}
		k++;
		return k;
	}

	// naive recursive solution.
	public static int allocatePages(int[] arr, int k) {
		if (arr.length == 1) {
			return arr[0];
		}
		int totalPages = 0;
		for (int i = 0; i < arr.length; i++) {
			totalPages += arr[i];
		}
		return findMinAllocationRec(arr, k, 0, totalPages);
	}

	// helper recursive method.
	private static int findMinAllocationRec(int[] arr, int k, int index, int totalSum) {
		if (k == 1) {
			return totalSum;
		}
		int sum = 0;
		int minValue = Integer.MAX_VALUE;
		for (int i = index; i < arr.length; i++) {
			totalSum = totalSum - arr[i];
			if (totalSum <= 0) {
				break;
			}
			sum = sum + arr[i];
			int temp = Math.max(sum, findMinAllocationRec(arr, k - 1, i + 1, totalSum));
			if (temp < minValue) {
				minValue = temp;
			}
		}
		return minValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40 };
		int[] arr1 = { 10, 20, 30 };
		int[] arr2 = { 10, 5, 30, 1, 2, 5, 10, 10 };
		System.out.println("The maximum number of pages read by any student is: " + allocatePages(arr, 2));
		System.out.println("The maximum number of pages read by any student is: " + allocatePages(arr1, 1));
		System.out.println("The maximum number of pages read by any student is: " + allocatePages(arr2, 3));
		System.out.println();
		System.out.println(
				"(Efficient) The maximum number of pages read by any student is: " + allocatePagesEfficient(arr, 2));
		System.out.println(
				"(Efficient) The maximum number of pages read by any student is: " + allocatePagesEfficient(arr1, 1));
		System.out.println(
				"(Efficient) The maximum number of pages read by any student is: " + allocatePagesEfficient(arr2, 3));
	}

}
