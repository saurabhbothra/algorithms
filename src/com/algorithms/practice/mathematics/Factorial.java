package com.algorithms.practice.mathematics;

// Given a integer n, find the factorial of n.

public class Factorial {
	
	// iterative solution.
	public static int factorial(int number) {
		if(number == 0) {
			return 1;
		}
		int factorial = 1;
		for(int i = number; i > 0; i--) {
			factorial = factorial * i;
		}
		return factorial;
	}
	
	// recursive solution.
	public static int factorialRecursive(int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		return number * factorialRecursive(number - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Factorial of the number is " + factorial(5));
		System.out.println("(Recursive) Factorial of the number is " + factorialRecursive(10));
	}

}
