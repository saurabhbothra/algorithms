package com.algorithms.practice.matrix;

import java.util.concurrent.ThreadLocalRandom;

public class MedianOfRowwiseSortedMatrix {

	// Given a odd-sized matrix, and every row is sorted in ascending order.
	// All elements of the matrix are distinct.
	// Find the median of the matrix.

	// efficient solution.
	public static int findMedianEfficient(int[][] matrix) {
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] < minValue) {
				minValue = matrix[i][0];
			}
			if (matrix[i][matrix[i].length - 1] > maxValue) {
				maxValue = matrix[i][matrix[i].length - 1];
			}
		}

		// fetch no of elements smaller than or equal to median.
		int medianIndex = ((matrix.length * matrix[0].length) + 1) / 2;
		while (minValue < maxValue) {
			int count = 0;
			int midVal = (minValue + maxValue) / 2;
			boolean flag = false;
			for (int i = 0; i < matrix.length; i++) {
				int start = 0;
				int end = matrix[i].length - 1;
				while (start <= end) {
					int mid = (start + end) / 2;
					if (matrix[i][mid] == midVal) {
						count = count + (mid - start + 1);
						flag = true;
						break;
					}
					if (matrix[i][mid] < midVal) {
						count = count + (mid - start + 1);
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			}
			if (count == medianIndex && flag) {
				return midVal;
			}
			if (count < medianIndex) {
				minValue = midVal + 1;
			} else {
				maxValue = midVal - 1;
			}
		}
		return minValue;
	}

	// naive solution
	public static int findMedian(int[][] matrix) {
		int[] arr = new int[matrix.length * matrix[0].length];
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				arr[index] = matrix[i][j];
				index++;
			}
		}
		int medianIndex = (arr.length - 1) / 2;
		return findKthSmallest(arr, medianIndex + 1);
	}

	// helper method for quick select algorithm.
	public static int findKthSmallest(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;
		while (start <= end) {
			int randIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
			int p = lomutoPartition(nums, start, end, randIndex);
			if (p == (k - 1)) {
				result = nums[p];
				break;
			} else if (p > (k - 1)) {
				end = p - 1;
			} else {
				start = p + 1;
			}
		}
		return result;
	}

	// helper method for doing lomuto partition with randomization.
	public static int lomutoPartition(int[] nums, int start, int end, int pivotIndex) {
		int temp = nums[end];
		nums[end] = nums[pivotIndex];
		nums[pivotIndex] = temp;
		int pivotElement = nums[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] < pivotElement) {
				i++;
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		i++;
		temp = nums[i];
		nums[i] = pivotElement;
		nums[end] = temp;
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 10, 20 }, { 15, 25, 35 }, { 5, 30, 40 } };
		int[][] arr1 = { { 2, 4, 6, 8, 10 }, { 1, 3, 5, 7, 9 }, { 100, 200, 400, 500, 800 } };
		int[][] arr2 = { { 5, 10, 20, 30, 40 }, { 1, 2, 3, 4, 6 }, { 11, 13, 15, 17, 19 } };
		System.out.println("The median of this matrix is: " + findMedian(arr));
		System.out.println("The median of this matrix is: " + findMedian(arr1));
		System.out.println("The median of this matrix is: " + findMedian(arr2));
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr));
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr1));
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr2));
	}

}
