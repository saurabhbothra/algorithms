package com.algorithms.practice.mathematics;

// Given a integer n, find whether n is a palindrome number.

public class PalindromeNumber {

	// iterative solution, taking reverse of the number.
	public static boolean isPalindromeNumber(int number) {
		if (number < 0) {
			return false;
		}
		int originalNumber = number;
		int reverseNumber = 0;
		while (originalNumber != 0) {
			int digit = originalNumber % 10;
			originalNumber = originalNumber / 10;
			reverseNumber = (reverseNumber * 10) + digit;
		}
		if (number == reverseNumber) {
			return true;
		} else {
			return false;
		}
	}

	// iterative solution, reverting only last half of a number.
	public static boolean isPalindromeNumberRevertHalf(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int originalNumber = x;
		int reverseNumber = 0;
		while (originalNumber > reverseNumber) {
			int digit = originalNumber % 10;
			originalNumber = originalNumber / 10;
			if (originalNumber == reverseNumber) {
				return true;
			}
			reverseNumber = (reverseNumber * 10) + digit;
		}
		return (originalNumber == reverseNumber);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is given number a palindrome: " + isPalindromeNumber(78987));
		System.out.println("(Revert Half) Is given number a palindrome: " + isPalindromeNumberRevertHalf(78987));
	}

}
