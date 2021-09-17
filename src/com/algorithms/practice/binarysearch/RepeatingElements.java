package com.algorithms.practice.binarysearch;

public class RepeatingElements {

	// Given an array of integers nums containing n + 1 integers where each integer
	// is in the range [1, n] inclusive.

	// There is only one repeated number in nums, return this repeated number.

	// You must solve the problem without modifying the array nums and uses only
	// constant extra space.

	// efficient solution, Floyd's Tortoise and Hare (Cycle Detection)
	public static int repeatingElement(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast;
	}

	// efficient solution, requires extra O(n) space.
	public static int repeatingElementExtraSpace(int[] nums) {
		boolean[] temp = new boolean[nums.length];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (temp[nums[i]]) {
				result = nums[i];
				break;
			}
			temp[nums[i]] = true;
		}
		return result;
	}

	// solution using binary search.
	public static int findDuplicate(int[] nums) {
		int start = 1;
		int end = nums.length - 1;
		int result = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (findCount(nums, mid) <= mid) {
				start = mid + 1;
			} else {
				result = mid;
				end = mid - 1;
			}
		}
		return result;
	}

	private static int findCount(int[] nums, int element) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= element) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println("The repeating element in this array is: " + repeatingElementExtraSpace(nums));
		System.out.println("(Efficient) The repeating element in this array is: " + repeatingElement(nums));
		System.out.println("(Binary Search) The repeating element in this array is: " + findDuplicate(nums));
	}

}
