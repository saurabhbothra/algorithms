package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class InfixToPrefix {

	// Convert infix expression to prefix expression.

	// efficient solution.
	public static String infoxToPrefix(String s) {
		StringBuilder postfixExpression = new StringBuilder();
		ArrayDeque<Character> st = new ArrayDeque<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			int precedence = precedence(ch);
			if (precedence == -1) {
				postfixExpression.append(ch);
			} else if (st.isEmpty() && precedence != -1) {
				st.push(ch);
			} else if (ch == ')') {
				st.push(ch);
			} else if (ch == '(') {
				while (!st.isEmpty() && st.peek() != ')') {
					char poppedOperator = st.pop();
					postfixExpression.append(poppedOperator);
				}
				st.pop();
			} else {
				while (!st.isEmpty() && precedence(st.peek()) > precedence) {
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
		return postfixExpression.reverse().toString();
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
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("a*b+c/d"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("(a-b/c)*(a/k-l)"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("x+y/z-w*u"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("(x+y)*(z+w)"));
	}

}
