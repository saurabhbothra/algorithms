package com.algorithms.practice.strings;

public class JewelsAndStones {

	// You're given strings jewels representing the types of stones that are jewels,
	// and stones representing the stones you have. Each character in stones is a
	// type of stone you have. You want to know how many of the stones you have are
	// also jewels.

	// Letters are case sensitive, so "a" is considered a different type of stone
	// from "A".

	// jewels and stones consist of only English letters.

	// All the characters of jewels are unique.

	// efficient implementation.
	public static int numJewelsInStones(String jewels, String stones) {
		int sum = 0;
		int[] arr = new int[128];
		for (int i = 0; i < stones.length(); i++) {
			arr[stones.charAt(i)] += 1;
		}
		for (int i = 0; i < jewels.length(); i++) {
			sum += arr[jewels.charAt(i)];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jewels = "aA";
		String stones = "aAAbbbb";
		System.out.println("The number of jewels are: " + numJewelsInStones(jewels, stones));
	}

}
