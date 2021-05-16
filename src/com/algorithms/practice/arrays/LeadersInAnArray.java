package com.algorithms.practice.arrays;

public class LeadersInAnArray {

	// Given an array of integers, sorted or unsorted, print all leaders in it.
	// An element is called leader if there is nothing greater than or equal to this
	// element on
	// right of it.

	// efficient solution.
	public static void printLeaders(int[] nums) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				System.out.print(nums[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 10, 4, 10, 6, 5, 2 };
		int[] arr1 = { 10, 20, 30 };
		int[] arr2 = { 30, 20, 10 };
		System.out.println("Leaders in the following arrays are: ");
		printLeaders(arr);
		System.out.println();
		printLeaders(arr1);
		System.out.println();
		printLeaders(arr2);
		System.out.println();
	}

}
