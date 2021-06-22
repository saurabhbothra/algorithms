package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class InfixToPostfixConversion {

	// Convert infix expression to postfix expression."

	// efficient solution.
	public static String infixToPostfixEfficient(String s) {
		StringBuilder postfixExpression = new StringBuilder();
		ArrayDeque<Character> st = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int precedence = precedence(ch);
			if (precedence == -1) {
				postfixExpression.append(ch);
			} else if (st.isEmpty() && precedence != -1) {
				st.push(ch);
			} else if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					char poppedOperator = st.pop();
					postfixExpression.append(poppedOperator);
				}
				st.pop();
			} else {
				while (!st.isEmpty() && precedence(st.peek()) >= precedence) {
					char poppedOperator = st.pop();
					postfixExpression.append(poppedOperator);
				}
				st.push(ch);
			}
		}
		while (!st.isEmpty()) {
			char poppedOperator = st.pop();
			postfixExpression.append(poppedOperator);
		}
		return postfixExpression.toString();
	}

	// helper method to find precedence of a operator.
	public static int precedence(char ch) {
		switch (ch) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '/':
		case '*':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The postfix expression for given infix string is: " + infixToPostfixEfficient("a+b*(c^d-e)^(f+g*h)-i"));
		System.out.println("The postfix expression for given infix string is: " + infixToPostfixEfficient("(a+b)*c"));
		System.out.println("The postfix expression for given infix string is: " + infixToPostfixEfficient("a^b^c"));
		System.out
				.println("The postfix expression for given infix string is: " + infixToPostfixEfficient("(a+b)*(c+d)"));
	}

}
