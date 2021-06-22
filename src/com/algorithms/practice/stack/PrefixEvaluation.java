package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class PrefixEvaluation {

	// Given a prefix evaluation, return its value.

	// efficient solution.
	public static int prefixEvaluation(String s) {
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				st.push(Character.getNumericValue(ch));
			} else {
				int operand1 = st.pop();
				int operand2 = st.pop();
				st.push(evaluate(operand1, operand2, ch));
			}
		}
		return st.peek();
	}

	// helper method to perform mathematical operations.
	public static int evaluate(int a, int b, char operator) {
		int result = 0;
		switch (operator) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '/':
			result = a / b;
			break;
		case '*':
			result = a * b;
			break;
		case '^':
			result = (int) Math.pow(a, b);
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The value for given prefix string is: " + prefixEvaluation("+*123"));
		System.out.println("The value for given prefix string is: " + prefixEvaluation("*+123"));
		System.out.println("The value for given prefix string is: " + prefixEvaluation("^1^23"));
	}

}
