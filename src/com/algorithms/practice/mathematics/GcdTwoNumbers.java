package com.algorithms.practice.mathematics;

public class GcdTwoNumbers {

	// Given two numbers a and b, we need to find GCD or HCF of a and b.

	// euclidean algorithm to find gcd - optimized version.
	public static int gcdEuclideanOptimized(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcdEuclideanOptimized(b, a % b);
		}
	}

	// euclidean algorithm to find gcd - basic version.
	public static int gcdEuclidean(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	// naive solution.
	public static int gcd(int a, int b) {
		int min = Math.min(a, b);
		while (min > 0) {
			if (a % min == 0 && b % min == 0) {
				break;
			}
			min--;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("GCD of two numbers is " + gcd(6, 7));
		System.out.println("(Basic Euclidean Algorithm) GCD of two numbers is " + gcdEuclidean(6, 7));
		System.out.println("(Optimized Euclidean Algorithm) GCD of two numbers is " + gcdEuclideanOptimized(6, 7));

	}

}
