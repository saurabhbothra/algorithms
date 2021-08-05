package com.algorithms.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class LeftmostRepeatingCharacter {

	// You are given a string S (both uppercase and lowercase characters). You need
	// to print the repeated character whose first appearance is leftmost.
	// Return the index of the character. If no character repeats then return -1.

	// efficient implementation.
	public static int repeatedCharacter(String S) {
		Set<Character> hset = new HashSet<>();
		int index = -1;
		for (int i = S.length() - 1; i >= 0; i--) {
			if (!hset.contains(S.charAt(i))) {
				hset.add(S.charAt(i));
			} else {
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "geeksforgeeks";
		System.out.println("The leftmost repeating character's index is: " + repeatedCharacter(s));
	}

}
