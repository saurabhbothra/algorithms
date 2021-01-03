package com.algorithms.practice.mathematics;

// Given two numbers a and b, find the LCM of a and b.

public class LcmTwoNumbers {

	// efficient solution based on formula -> a * b = LCM * HCF.
	public static int lcmEfficient(int a, int b) {
		int hcf = hcf(a, b);
		return (a * b) / hcf;
	}

	// privte helper method to find hcf.
	private static int hcf(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return hcf(b, a % b);
		}
	}

	// naive solution.
	public static int lcm(int a, int b) {
		int max = Math.max(a, b);
		while (true) {
			if (max % a == 0 && max % b == 0) {
				break;
			}
			max++;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("LCM of two numbers is " + lcm(12, 15));
		System.out.println("(Efficient Solution) LCM of two numbers is " + lcmEfficient(12, 15));
	}

}
