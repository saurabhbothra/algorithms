package com.algorithms.practice.recursion;

public class JosephusProblem {

	// Given the total number of persons n and a number k which indicates that k-1
	// persons are skipped and kth person is killed in circle in a fixed direction.
	// The task is to choose the safe place in the circle so that when you perform
	// these operations starting from 1st place in the circle, you are the last one
	// remaining and survive.

	// recursive solution.
	public static int josephus(int n, int k) {
		if (n == 1) {
			return 0;
		}
		return (k + josephus(n - 1, k)) % n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The safest place in circle is: " + josephus(7, 3));
	}

}
