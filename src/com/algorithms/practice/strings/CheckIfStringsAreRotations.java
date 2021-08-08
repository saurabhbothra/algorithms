package com.algorithms.practice.strings;

public class CheckIfStringsAreRotations {

	// Given two strings s1 and s2. The task is to check if s2 is a rotated version
	// of the string s1. The characters in the strings are in lowercase.

	// naive solution.
	public static boolean areRotationsNaive(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s.substring(1, s.length()));
			sb.append(s.charAt(0));
			s = sb.toString();
			if (s.equals(goal)) {
				return true;
			}
		}
		return false;
	}

	// efficient solution.
	public static boolean areRotations(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		StringBuilder sb = new StringBuilder(s);
		sb.append(s);
		s = sb.toString();
		if (s.contains(goal)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcde";
		String s2 = "cdeab";
		System.out.println("Are strings rotations of each other: " + areRotations(s1, s2));
	}

}
