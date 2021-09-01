package com.algorithms.practice.bitmagic;

public class PowerSetUsingBitwise {

	// Given a string that represents a set with distinct characters, generate all
	// subsets of the given string.

	// efficient solution.
	public static void generateSubsets(String s) {
		int noOfSubsets = (int) Math.pow(2, s.length());
		for (int i = 0; i < noOfSubsets; i++) {
			int counter = i;
			int index = 0;
			StringBuilder sb = new StringBuilder();
			while (counter != 0) {
				if ((counter & 1) != 0) {
					sb.append(s.charAt(index));
				}
				index++;
				counter = counter >> 1;
			}
			System.out.print(sb.toString() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The subsets are:");
		generateSubsets("abc");
		System.out.println();
		System.out.println("The subsets are:");
		generateSubsets("ab");
	}

}
