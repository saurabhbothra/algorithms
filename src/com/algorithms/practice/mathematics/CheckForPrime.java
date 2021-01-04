package com.algorithms.practice.mathematics;

// Given a number n which is greater than zero, check if n is prime.

public class CheckForPrime {

	// further optimizations, adding checks for divisibility by 2 and 3.
	public static boolean isPrimeEfficient2(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2 || n == 3) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for (int i = 5; i <= sqrt; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	// efficient solution, check till square root of n.
	public static boolean isPrimeEfficient(int n) {
		if (n == 1) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// naive solution.
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is given number prime? " + isPrime(101));
		System.out.println("(Efficient Solution) Is given number prime? " + isPrimeEfficient(101));
		System.out.println("(Efficient Solution 2) Is given number prime? " + isPrimeEfficient2(101));
	}

}
