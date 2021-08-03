package com.algorithms.practice.backtracking;

public class StringPermutations {

	// Given a string, print all those permutations that does not contain AB as a
	// substring.

	// naive solution.
	public static void printPermutations(String s) {
		if (s == null || s.length() == 0) {
			return;
		}
		permutationsRec(s, 0);
	}

	// helper method to find permutations.
	public static void permutationsRec(String s, int level) {
		if (s.length() == level) {
			if (!s.contains("AB")) {
				System.out.print(s + " ");
			}
			return;
		}
		for (int i = level; i < s.length(); i++) {
			char[] ch = s.toCharArray();
			char temp = ch[level];
			ch[level] = ch[i];
			ch[i] = temp;
			String str = String.valueOf(ch);
			permutationsRec(str, level + 1);
		}
	}

	// helper method to cut down recursion tree.
	public static boolean isSafe(String s, int level, int i) {
		if (level >= 1 && s.charAt(level - 1) == 'A' && s.charAt(i) == 'B') {
			return false;
		}
		return true;
	}

	// efficient solution, using backtracking.
	public static void permutationsBackTrack(String s, int level) {
		if (s.length() == level) {
			System.out.print(s + " ");
			return;
		}
		for (int i = level; i < s.length(); i++) {
			if (isSafe(s, level, i)) {
				char[] ch = s.toCharArray();
				char temp = ch[level];
				ch[level] = ch[i];
				ch[i] = temp;
				String str = String.valueOf(ch);
				permutationsRec(str, level + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		System.out.println("The permutations of the given string are:");
		permutationsBackTrack(s, 0);
	}

}
