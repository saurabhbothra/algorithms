package com.algorithms.practice.general;

public class GoalParserInterpretation {

	// You own a Goal Parser that can interpret a string command. The command
	// consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal
	// Parser will interpret "G" as the string "G", "()" as the string "o", and
	// "(al)" as the string "al". The interpreted strings are then concatenated in
	// the original order.

	// Given the string command, return the Goal Parser's interpretation of command.

	// efficient solution.
	public static String interpret(String command) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < command.length()) {
			if (command.charAt(i) == 'G') {
				sb.append("G");
				i++;
			} else {
				int j = i + 1;
				while (j < command.length() && command.charAt(j) != ')') {
					j++;
				}
				if (j == i + 1) {
					sb.append("o");
				} else {
					sb.append("al");
				}
				i = j + 1;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "G()()()()(al)";
		System.out.println("The interpretation of command is: " + interpret(s));
	}

}
