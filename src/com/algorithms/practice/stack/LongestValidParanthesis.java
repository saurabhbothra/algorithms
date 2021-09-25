package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class LongestValidParanthesis {

	// Given a string containing just the characters '(' and ')', find the length of
	// the longest valid (well-formed) parentheses substring.

	// solution using stack.
	public static int longestValidParentheses(String s) {
		int maxLength = 0;
		ArrayDeque<Integer> st = new ArrayDeque<>();
		st.push(-1);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.isEmpty()) {
					st.push(i);
				} else {
					maxLength = Math.max(maxLength, i - st.peek());
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The longest valid paranthesis is: " + longestValidParentheses(")()())"));
	}

}
