package com.algorithms.practice.dp;

public class LongestIncreasingSubsequence {

	// Given an integer array nums, return the length of the longest strictly
	// increasing subsequence.

	// A subsequence is a sequence that can be derived from an array by deleting
	// some or no elements without changing the order of the remaining elements. For
	// example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

	// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
	// complexity?

	public int maxLengthLis = 1;

	// simple plain recursive solution.
	public int lengthOfLISSimple(int[] nums) {
		lenRec(nums, nums.length - 1);
		return maxLengthLis;
	}

	public int lenRec(int[] nums, int n) {
		if (n == 0) {
			return 1;
		}
		int len = 1;
		for (int i = 0; i < n; i++) {
			int temp = lenRec(nums, i);
			if (nums[i] < nums[n]) {
				len = Math.max(len, 1 + temp);
			}
		}

		if (maxLengthLis < len) {
			maxLengthLis = len;
		}
		return len;
	}

	// memoization.
	public int lengthOfLISMemo(int[] nums) {
		int[] memo = new int[nums.length];
		lenRec(nums, nums.length - 1, memo);
		int maxLengthLis = 1;
		for (int i = 0; i < memo.length; i++) {
			if (memo[i] > maxLengthLis) {
				maxLengthLis = memo[i];
			}
		}
		return maxLengthLis;
	}

	public int lenRec(int[] nums, int n, int[] memo) {
		if (n == 0) {
			memo[n] = 1;
		}
		if (memo[n] == 0) {
			int len = 1;
			for (int i = 0; i < n; i++) {
				int temp = lenRec(nums, i, memo);
				if (nums[i] < nums[n]) {
					len = Math.max(len, 1 + temp);
				}
			}
			memo[n] = len;
		}
		return memo[n];
	}

	// tabulation.
	public int lengthOfLISTabulation(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int len = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					int res = 1 + dp[j];
					len = Math.max(len, res);
				}
			}
			dp[i] = len;
		}
		int maxLengthLis = 1;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > maxLengthLis) {
				maxLengthLis = dp[i];
			}
		}
		return maxLengthLis;
	}

	// efficient solution.
	public int lengthOfLISEfficient(int[] nums) {
		int[] tail = new int[nums.length];
		int index = 1;
		tail[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > tail[index - 1]) {
				tail[index] = nums[i];
				index++;
			} else {
				int rIndex = findCeilIndex(tail, 0, index - 1, nums[i]);
				tail[rIndex] = nums[i];
			}
		}
		return index;
	}

	public int findCeilIndex(int[] tail, int start, int end, int element) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (tail[mid] == element) {
				return mid;
			}
			if (tail[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println("The length of longest increasing subsequence is: " + lis.lengthOfLISEfficient(nums));
	}

}
