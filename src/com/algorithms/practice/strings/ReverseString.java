package com.algorithms.practice.strings;

import java.util.Arrays;

public class ReverseString {

	// Write a function that reverses a string. The input string is given as an
	// array of characters s.
	// Follow up: Do not allocate extra space for another array. You must do this by
	// modifying the input array in-place with O(1) extra memory.

	// efficient implementation.
	public static void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(s);
		System.out.println("The reversed string is: " + Arrays.toString(s));
	}

}
