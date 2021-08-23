package com.algorithms.practice.dp;

public class AllocateMinimumPages {

	// Given an array in which element represents number of pages in a book.We are
	// also given a number k which represents number of students.

	// The k students are supposed to read all the books.
	// A student can read only contiguous books.
	// Minimize the maximum number of pages read by any student.

	// simple recursive solution.
	public int allocatePagesSimple(int[] nums, int m) {
		int totalSum = 0;
		for (int i : nums) {
			totalSum += i;
		}
		return spRec(nums, m, totalSum, 0);
	}

	public int spRec(int[] nums, int m, int sum, int index) {
		if (m == 1) {
			return sum;
		}
		if (index == nums.length) {
			return 0;
		}
		int minVal = Integer.MAX_VALUE;
		int curr = 0;
		for (int i = index; i < nums.length; i++) {
			curr += nums[i];
			int subResult = Math.max(curr, spRec(nums, m - 1, sum - curr, i + 1));
			minVal = Math.min(minVal, subResult);
		}
		return minVal;
	}

	// memoization.
	public int allocatePagesMemo(int[] nums, int m) {
		Integer[][] memo = new Integer[m + 1][nums.length + 1];
		int totalSum = 0;
		for (int i : nums) {
			totalSum += i;
		}
		return spRec(nums, m, totalSum, 0, memo);
	}

	public int spRec(int[] nums, int m, int sum, int index, Integer[][] memo) {
		if (m == 1) {
			memo[m][index] = sum;
		}
		if (index == nums.length) {
			memo[m][index] = 0;
		}
		if (memo[m][index] == null) {
			int minVal = Integer.MAX_VALUE;
			int curr = 0;
			for (int i = index; i < nums.length; i++) {
				curr += nums[i];
				int subResult = Math.max(curr, spRec(nums, m - 1, sum - curr, i + 1, memo));
				minVal = Math.min(minVal, subResult);
			}
			memo[m][index] = minVal;
		}
		return memo[m][index];
	}

	// tabulation.
	public int allocatePagesTabulation(int[] nums, int m) {
		int[][] dp = new int[m + 1][nums.length + 1];
		int temp = 0;
		for (int j = nums.length - 1; j >= 0; j--) {
			temp = temp + nums[j];
			dp[1][j] = temp;
		}
		for (int i = 2; i <= m; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				int curr = 0;
				int minVal = Integer.MAX_VALUE;
				for (int k = j; k < nums.length; k++) {
					curr = curr + nums[k];
					int subResult = Math.max(curr, dp[i - 1][k + 1]);
					minVal = Math.min(minVal, subResult);
				}
				dp[i][j] = minVal;
			}
		}
		return dp[m][0];
	}

	// efficient solution.
	public int allocatePagesEfficient(int[] arr, int k) {
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
	private int findActualK(int[] arr, int m) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllocateMinimumPages amp = new AllocateMinimumPages();
		int[] arr = { 10, 20, 30, 40 };
		int[] arr1 = { 10, 20, 30 };
		int[] arr2 = { 10, 5, 30, 1, 2, 5, 10, 10 };
		System.out.println("The maximum number of pages read by any student is: " + amp.allocatePagesSimple(arr, 2));
		System.out.println("The maximum number of pages read by any student is: " + amp.allocatePagesMemo(arr1, 1));
		System.out
				.println("The maximum number of pages read by any student is: " + amp.allocatePagesTabulation(arr2, 3));
		System.out
				.println("The maximum number of pages read by any student is: " + amp.allocatePagesEfficient(arr2, 3));
	}

}
