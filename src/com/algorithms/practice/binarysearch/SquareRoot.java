package com.algorithms.practice.binarysearch;

public class SquareRoot {

	// Given a non-negative integer x, compute and return the square root of x.

	// Since the return type is an integer, the decimal digits are truncated, and
	// only the integer part of the result is returned.

	// efficient solution, binary search.
	public static int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		int start = 2;
		int end = x / 2;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			long mySq = (long) mid * mid;
			if (mySq == x) {
				return mid;
			} else if (mySq > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The square root of this number is: " + mySqrt(25));
	}

}
