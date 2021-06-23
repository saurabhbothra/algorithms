package com.algorithms.practice.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {

	// Given a number n, print first n numbers (in increasing order) such that all
	// these numbers have digit in set {5, 6}.
	// n can be a very big number and the result values might not fir in basic data
	// types like long int or long long int.

	// efficient solution.
	public static void printNumbers(int n) {
		if (n == 0) {
			return;
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(5);
		q.offer(6);
		while (n > 0) {
			int item = q.poll();
			System.out.print(item + " ");
			q.offer((item * 10) + 5);
			q.offer((item * 10) + 6);
			n--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The numbers are:");
		printNumbers(10);
	}

}
