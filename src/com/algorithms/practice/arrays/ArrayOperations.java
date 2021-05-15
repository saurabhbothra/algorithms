package com.algorithms.practice.arrays;

import java.util.Arrays;

public class ArrayOperations {

	// implement all basic operations in an array.

	// search an element in an unsorted array.
	public static boolean searchInUnsortedArray(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	// inserting an element in array, returns the new capacity of the array. (fixed size arrays)
	public static int insert(int[] arr, int x, int position, int capacity) {
		if (capacity == arr.length) {
			return arr.length;
		}
		int lastElementIndex = capacity - 1;
		for(int i = lastElementIndex; i >= position; i--) {
			arr[i + 1] = arr[i];
		}
		arr[position] = x;
		return capacity + 1;
	}
	
	// deleting an element in the array, reduce the size of the array after deleting the element.
	public static void delete(int[] arr, int element) {
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == element) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return;
		}
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = 0;
		System.out.println("After deletion, array is: " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 5, 7, 25 };
		System.out.println("Is element in array: " + searchInUnsortedArray(arr, 25));
		int[] insertArr = new int[6];
		insertArr[0] = 5;
		insertArr[1] = 7;
		insertArr[2] = 10;
		insertArr[3] = 20;
		insertArr[4] = 25;
		System.out.println("Element inserted at position: " + insert(insertArr, 3, 2, 5));
		delete(arr, 5);
	}

}
