package com.algorithms.practice.arrays;

public class FrequenciesInASortedArray {

	// Given a sorted array, print frequencies of all elements in the array.

	public static void findFrequencies(int[] arr) {
		if (arr.length == 0) {
			System.out.print("Array is empty.");
			return;
		}
		int temp = arr[0];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == temp) {
				count++;
			} else {
				System.out.println(temp + " " + count);
				count = 1;
				temp = arr[i];
			}
		}
		System.out.println(temp + " " + count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 10, 10, 25, 30, 30 };
		System.out.println("The frequencies of elements in array are: ");
		findFrequencies(arr);
	}

}
