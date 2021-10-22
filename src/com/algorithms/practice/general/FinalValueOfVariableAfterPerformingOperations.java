package com.algorithms.practice.general;

public class FinalValueOfVariableAfterPerformingOperations {

	// There is a programming language with only four operations and one variable X:

	// ++X and X++ increments the value of the variable X by 1.
	// --X and X-- decrements the value of the variable X by 1.
	// Initially, the value of X is 0.

	// Given an array of strings operations containing a list of operations, return
	// the final value of X after performing all the operations.

	// efficient solution.
	public static int finalValueAfterOperations(String[] operations) {
		int x = 0;
		for (String oper : operations) {
			if (oper.charAt(0) == '+' || oper.charAt(2) == '+') {
				x++;
			} else {
				x--;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = { "X++", "++X", "--X", "X--" };
		System.out.println("Final value of x is: " + finalValueAfterOperations(operations));
	}

}
