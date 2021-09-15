package com.algorithms.practice;

public class demo {

	public static void findFrequencies(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			int count = 1;
			int j = i + 1;
			while(j < arr.length && arr[j] == arr[i]) {
				count++;
				j++;
			}
			System.out.println(arr[i] + " " + count);
			i = j;
		}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 10, 10, 25, 30, 30 };
		System.out.println("The frequencies of elements in array are: ");
		findFrequencies(arr);
	}
}
