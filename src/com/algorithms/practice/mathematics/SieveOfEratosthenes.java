package com.algorithms.practice.mathematics;

public class SieveOfEratosthenes {

	// Given a number n, print all prime numbers smaller than or equal to n.

	// sieve of eratosthenes algorithm.
	public static void sieveOfEratosthenes(int n) {
		if (n <= 1) {
			return;
		}
		System.out.println("All prime numbers smaller than or equal to n");
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				int index = 2;
				int temp = i * index;
				while (temp <= n) {
					isPrime[temp] = false;
					index++;
					temp = i * index;
				}
			}
		}
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sieveOfEratosthenes(23);

	}

}
