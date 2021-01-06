package com.algorithms.practice.mathematics;

// Given a number n, print all divisors of the number in increasing order.

public class AllDivisorsNumber {

	// efficient solution, with sorting.
	public static void printAllDivisorsEfficientSorting(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println("All Divisors");
		int sqrt = (int) Math.sqrt(n);
		for (int i = 1; i < sqrt; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		for (int i = sqrt; i >= 1; i--) {
			if (n % i == 0) {
				System.out.print((n / i) + " ");
			}
		}
		System.out.println();
	}

	// efficient solution, without sorting.
	public static void printAllDivisorsEfficient(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println("All Divisors");
		int sqrt = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != (n / i)) {
					System.out.print(n / i + " ");
				}
			}
		}
		System.out.println();
	}

	// naive solution.
	public static void printAllDivisors(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println("All Divisors");
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllDivisors(100);
		printAllDivisorsEfficient(100);
		printAllDivisorsEfficientSorting(100);
	}

}
