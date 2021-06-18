package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class BalancedParanthesis {

	// Given a string s containing just the characters '(', ')', '{', '}', '[' and
	// ']', determine if the input string is valid.

	// An input string is valid if:
	// Open brackets must be closed by the same type of brackets.
	// Open brackets must be closed in the correct order.

	// efficient solution.
	public static boolean isValid(String s) {
		ArrayDeque<Character> st = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '[' || temp == '{' || temp == '(') {
				st.push(temp);
			} else {
				if (st.isEmpty()) {
					return false;
				}
				char popped = st.pop();
				if ((temp == ']' && popped == '[') || (temp == '}' && popped == '{')
						|| (temp == ')' && popped == '(')) {
					continue;
				} else {
					return false;
				}
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(){}[]";
		System.out.println("Is given string balanced: " + isValid(s));
	}

}
