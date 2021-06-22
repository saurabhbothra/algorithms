package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class PostfixEvaluation {

	// Given a post fix expression, compute its value.

	// efficient solution.
	public static int postfixEvaluation(String S) {
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
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
			result = b - a;
			break;
		case '/':
			result = b / a;
			break;
		case '*':
			result = a * b;
			break;
		case '^':
			result = (int) Math.pow(b, a);
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The value for given postfix string is: " + postfixEvaluation("12*3+"));
		System.out.println("The value for given postfix string is: " + postfixEvaluation("12+3*"));
		System.out.println("The value for given postfix string is: " + postfixEvaluation("123^^"));
	}

}
