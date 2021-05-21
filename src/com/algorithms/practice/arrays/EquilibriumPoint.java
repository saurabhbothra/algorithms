package com.algorithms.practice.arrays;

public class EquilibriumPoint {

	// Given an array, we need to find if it has an equilibrium point.

	// efficient solution, requires theta(1) space.
	public static boolean isEquilibriumPointEfficient(int[] arr) {
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (leftSum == totalSum - leftSum - arr[i]) {
				return true;
			}
			leftSum = leftSum + arr[i];
		}
		return false;
	}

	// prefix sum solution, requires theta(n) extra space.
	public static boolean isEquilibriumPoint(int[] arr) {
		int currSum = 0;
		int[] leftPrefixSum = new int[arr.length];
		int[] rightPrefixSum = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			currSum = currSum + arr[i];
			leftPrefixSum[i] = currSum;
		}
		currSum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			currSum = currSum + arr[i];
			rightPrefixSum[i] = currSum;
		}

		for (int i = 0; i < arr.length; i++) {
			if (leftPrefixSum[i] - arr[i] == rightPrefixSum[i] - arr[i]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 4, 8, -9, 20, 6 };
		int[] arr1 = { 4, 2, -2 };
		int[] arr2 = { 4, 2, 2 };
		System.out.println("Is Equilibrium point in this array: " + isEquilibriumPoint(arr));
		System.out.println("Is Equilibrium point in this array: " + isEquilibriumPoint(arr1));
		System.out.println("Is Equilibrium point in this array: " + isEquilibriumPoint(arr2));
		System.out.println();
		System.out.println("(Efficient) Is Equilibrium point in this array: " + isEquilibriumPointEfficient(arr));
		System.out.println("(Efficient) Is Equilibrium point in this array: " + isEquilibriumPointEfficient(arr1));
		System.out.println("(Efficient) Is Equilibrium point in this array: " + isEquilibriumPointEfficient(arr2));
	}

}
