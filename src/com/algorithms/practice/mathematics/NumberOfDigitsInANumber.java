package com.algorithms.practice.mathematics;

// Given a integer n, find the number of digits in n.

public class NumberOfDigitsInANumber {

	// logarithmic solution only for positive numbers.
	public static int getNumberOfDigitsLogarithmic(long number) {
		return (int) Math.floor(Math.log10(number) + 1);
	}

	// recursive solution.
	public static int getNumberOfDigitsRecursive(long number) {
		if (number == 0) {
			return 0;
		}
		return 1 + getNumberOfDigitsRecursive(number / 10);
	}

	// iterative solution.
	public static int getNumberOfDigits(long number) {
		if (number == 0) {
			return 1;
		}
		int result = 0;
		while (number != 0) {
			number = number / 10;
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfDigitsIterative = getNumberOfDigits(485);
		int numberOfDigitsRecursive = getNumberOfDigitsRecursive(485);
		int numberOfDigitsLogarithmic = getNumberOfDigitsLogarithmic(485);
		System.out.println("(Iterative) Number of Digits is " + numberOfDigitsIterative);
		System.out.println("(Recursive) Number of Digits is " + numberOfDigitsRecursive);
		System.out.println("(Logarithmic) Number of Digits is " + numberOfDigitsLogarithmic);
	}

}
