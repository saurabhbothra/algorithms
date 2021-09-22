package com.algorithms.practice;

public class demo {

	public int inverseMemo(int[] nums, int k) {
		Integer[][] memo = new Integer[k + 1][nums.length + 1];
		return inversionRec(nums, k, 0, memo);
	}

	public int inversionRec(int[] nums, int k, int index, Integer[][] memo) {
		if (k == 1) {
			memo[k][index] = 1;
		} else if (index == nums.length) {
			memo[k][index] = 0;
		}
		if (memo[k][index] == null) {
			int count = 0;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[index] > nums[i]) {
					count = count + inversionRec(nums, k - 1, i, memo);
				}
			}
			if (k == 3) {
				count = count + inversionRec(nums, k, index + 1, memo);
			}
			memo[k][index] = count;
		}
		return memo[k][index];
	}

	public int inversionTabulation(int[] nums, int k) {
		int[][] dp = new int[k + 1][nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= k; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				int count = 0;
				for (int a = j + 1; a < nums.length; a++) {
					if (nums[j] > nums[a]) {
						count = count + dp[i - 1][a];
					}
				}
				if (i == 3) {
					count = count + dp[i][j + 1];
				}
				dp[i][j] = count;
			}
		}
		return dp[k][0];
	}

	// efficient solution.
	public static int findMedianEfficient(int[][] matrix) {
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		int medianElement = 0;
		int medianPosition = ((matrix.length * matrix[0].length) + 1) / 2;
		for (int i = 0; i < matrix.length; i++) {
			minVal = Math.min(minVal, matrix[i][0]);
			maxVal = Math.max(maxVal, matrix[i][matrix[0].length - 1]);
		}

		while (minVal <= maxVal) {
			int midVal = (minVal + maxVal) / 2;
			int count = binarySearch(matrix, midVal);
			if (count == medianPosition) {
				medianElement = midVal;
				break;
			}
			if (count > medianPosition) {
				maxVal = midVal - 1;
			} else {
				minVal = midVal + 1;
			}
		}
		return medianElement;
	}

	private static int binarySearch(int[][] matrix, int element) {
		int count = 1;
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = matrix[i];
			int start = 0;
			int end = arr.length - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (arr[mid] < element) {
					count += mid - start + 1;
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 5, 4, 3, 2, 1 };
		int[] nums1 = { 5, 5, 2, 2, 1 };
		demo d = new demo();
		System.out.println(d.inverseMemo(nums, 3));
		System.out.println(d.inverseMemo(nums1, 3));

		System.out.println(d.inversionTabulation(nums, 3));
		System.out.println(d.inversionTabulation(nums1, 3));

		System.out.println();

		int[][] arr = { { 1, 10, 20 }, { 15, 25, 35 }, { 5, 30, 40 } };
		int[][] arr1 = { { 2, 4, 6, 8, 10 }, { 1, 3, 5, 7, 9 }, { 100, 200, 400, 500, 800 } };
		int[][] arr2 = { { 5, 10, 20, 30, 40 }, { 1, 2, 3, 4, 6 }, { 11, 13, 15, 17, 19 } };
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr));
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr1));
		System.out.println("(Efficient) The median of this matrix is: " + findMedianEfficient(arr2));
	}
}
