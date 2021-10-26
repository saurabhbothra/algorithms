package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInAString {

	// You are given a string s consisting of lowercase English letters. A duplicate
	// removal consists of choosing two adjacent and equal letters and removing
	// them.

	// We repeatedly make duplicate removals on s until we no longer can.

	// Return the final string after all such duplicate removals have been made. It
	// can be proven that the answer is unique.

	// efficient solution 1.
	public static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (sb.length() == 0) {
				sb.append(ch);
			} else {
				if (sb.charAt(sb.length() - 1) == ch) {
					if (sb.length() > 0) {
						sb.setLength(sb.length() - 1);
					}
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	// efficient solution using deque.
	public static String removeDuplicatesDeque(String s) {
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> dq = new ArrayDeque<>();
		dq.offerLast(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!dq.isEmpty() && dq.peekLast() == ch) {
				dq.pollLast();
			} else {
				dq.offerLast(ch);
			}
		}
		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbaca";
		System.out.println("The distinct string is: " + removeDuplicates(s));
		System.out.println("The distinct string is: " + removeDuplicatesDeque(s));
	}

}
