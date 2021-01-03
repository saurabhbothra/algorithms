package com.algorithms.practice.mathematics;

import java.math.BigInteger;

// Given a integer n, return the number of trailing zeros in n!.

public class FactorialTrailingZeros {

	// counting factors of five efficiently (second).
	public static int efficient2TrailingZerosFactorial(int n) {
		int fiveCount = 0;
		while (n > 0) {
			n = n / 5;
			fiveCount = fiveCount + n;
		}
		return fiveCount;
	}

	// counting factors of five efficiently.
	public static int efficientTrailingZerosFactorial(int n) {
		int fiveCount = 0;
		int powerOfFive = 5;
		while (n >= powerOfFive) {
			fiveCount = fiveCount + (n / powerOfFive);
			powerOfFive = powerOfFive * 5;
		}
		return fiveCount;
	}

	// keep a count of all five's involved in the multiplication.
	public static int getTrailingZerosFactorialCount(int n) {
		if (n == 0) {
			return 0;
		}
		int fiveCount = 0;
		for (int i = 5; i <= n; i = i + 5) {
			int powerOfFive = 5;
			while (i % powerOfFive == 0) {
				fiveCount = fiveCount + 1;
				powerOfFive = powerOfFive * 5;
			}
		}
		return fiveCount;
	}

	// naive solution, can lead to integer overflow issues.
	public static int getTrailingZerosFactorial(int n) {
		if (n == 0) {
			return 0;
		}
		BigInteger factorial = BigInteger.ONE;
		int count = 0;
		for (int i = n; i > 1; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		while (factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
			count++;
			factorial = factorial.divide(BigInteger.TEN);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Numer of trailing zeros in the factorial is " + getTrailingZerosFactorial(30));
		System.out.println(
				"(Second Solution) Numer of trailing zeros in the factorial is " + getTrailingZerosFactorialCount(30));
		System.out.println("(Efficient Solution) Numer of trailing zeros in the factorial is "
				+ efficientTrailingZerosFactorial(30));
		System.out.println("(Efficient Solution 2) Numer of trailing zeros in the factorial is "
				+ efficient2TrailingZerosFactorial(30));

	}

}
