package com.algorithms.practice.bitmagic;

public class PowerOf2 {

	// Given an integer n, return true if it is a power of two. Otherwise, return
	// false.

	// An integer n is a power of two, if there exists an integer x such that n ==
	// 2^x.

	// Follow up: Could you solve it without loops/recursion?

	public static int countSetBitsAlgo(int n) {
		int res = 0;
		while (n > 0) {
			n = n & (n - 1);
			res++;
		}
		return res;
	}

	// efficient solution, using bitwise manipulation.
	public static boolean isPowerOfTwo(int n) {
		int res = countSetBitsAlgo(n);
		return res == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is n power of 2: " + isPowerOfTwo(16));
	}

}
