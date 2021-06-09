package com.algorithms.practice.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

	// Given an unsorted array of integers nums, return the length of the longest
	// consecutive elements sequence.

	// You must write an algorithm that runs in O(n) time.

	// naive solution.
	public static int longestConsecutiveNaive(int[] nums) {
		Arrays.sort(nums);
		int maxLength = 0;
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				len++;
				continue;
			}
			if (nums[i] == nums[i - 1] + 1) {
				len++;
			} else if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				maxLength = Math.max(maxLength, len);
				len = 1;
			}
		}
		return Math.max(maxLength, len);
	}

	// efficient solution.
	public static int longestConsecutive(int[] nums) {
		Set<Integer> hset = new HashSet<>();
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			hset.add(nums[i]);
		}
		for (int num : hset) {
			int len = 0;
			if (!hset.contains(num - 1)) {
				int temp = num;
				while (hset.contains(temp)) {
					len++;
					temp++;
				}
				maxLength = Math.max(maxLength, len);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println("The length of longest consecutive sequence is: " + longestConsecutive(nums));
	}

}
