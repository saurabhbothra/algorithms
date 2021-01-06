package com.algorithms.practice.mathematics;

// Given two numbers x and n, compute x raised to n.

public class ComputingPower {

	// efficient solution, fast power algorithm recursive.
	public static double computePowerEfficientRecursive(double x, int n) {
		if (n == 0) {
			return 1;
		}
		long temp = n;
		if (temp < 0) {
			temp = temp * -1;
		}
		double result = powRecursive(x, temp);
		if (n < 0) {
			return 1 / result;
		}
		return result;
	}

	// helper recursive method to find power.
	private static double powRecursive(double x, long n) {
		if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			return powRecursive(x * x, n / 2);
		} else {
			return powRecursive(x, n - 1) * x;
		}
	}

	// efficient solution, fast power algorithm iterative.
	public static double computePowerEfficient(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		long temp = n;
		if (temp < 0) {
			temp = temp * -1;
		}
		double result = x;
		double remainder = 1;
		while (temp > 1) {
			if (temp % 2 != 0) {
				remainder = remainder * result;
			}
			result = result * result;
			temp = temp / 2;
		}
		if (n < 0) {
			return 1 / (result * remainder);
		}
		return result * remainder;
	}

	// naive solution.
	public static double computePower(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double result = 1;
		int temp = Math.abs(n);
		for (int i = 1; i <= temp; i++) {
			result = result * x;
		}
		if (n < 0) {
			return 1 / result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The answer of x raised to n is " + computePower(2, -2));
		System.out.println("(Efficient Solution) The answer of x raised to n is " + computePowerEfficient(2, -2));
		System.out.println("(Efficient Solution Recursive) The answer of x raised to n is "
				+ computePowerEfficientRecursive(2, -2));
	}

}
