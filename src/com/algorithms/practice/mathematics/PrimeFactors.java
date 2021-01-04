package com.algorithms.practice.mathematics;

public class PrimeFactors {

	// Given a number n which is greater than 1, find prime factors of this number.

	// further optimizations, adding checks for 2 and 3 explicitly to avoid any
	// iterations further.
	public static void primeFactorsEfficient2(int n) {
		System.out.println("Prime Factors");
		if (n <= 1) {
			return;
		}
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n = n / 2;
		}
		while (n % 3 == 0) {
			System.out.print(3 + " ");
			n = n / 3;
		}
		for (int i = 5; i * i <= n; i = i + 6) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
			while (n % (i + 2) == 0) {
				System.out.print((i + 2) + " ");
				n = n / (i + 2);
			}
		}
		if (n > 3) {
			System.out.print(n);
		}
		System.out.println();
	}

	// efficient solution, number can be written as multiplication of powers of its
	// prime factors.
	public static void primeFactorsEfficient(int n) {
		System.out.println("Prime Factors");
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
		}
		if (n > 1) {
			System.out.print(n);
		}
		System.out.println();
	}

	// naive solution.
	public static void primeFactors(int n) {
		System.out.println("Prime Factors");
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				int temp = i;
				while (n % temp == 0) {
					System.out.print(i + " ");
					temp = temp * i;
				}
			}
		}
		System.out.println();
	}

	private static boolean isPrime(int n) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeFactors(315);
		primeFactorsEfficient(315);
		primeFactorsEfficient2(315);
	}

}
