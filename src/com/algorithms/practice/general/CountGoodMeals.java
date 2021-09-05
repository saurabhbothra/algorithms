package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class CountGoodMeals {

	// A good meal is a meal that contains exactly two different food items with a
	// sum of deliciousness equal to a power of two.

	// You can pick any two different foods to make a good meal.

	// Given an array of integers deliciousness where deliciousness[i] is the
	// deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of
	// different good meals you can make from this list modulo 109 + 7.

	// Note that items with different indices are considered different even if they
	// have the same deliciousness value.

	// 1 <= deliciousness.length <= 105
	// 0 <= deliciousness[i] <= 220

	// efficient solution using hash map.
	public static int countPairsHash(int[] deliciousness) {
		long count = 0;
		int[] powers = new int[22];
		powers[0] = 1;
		for (int i = 1; i < 22; i++) {
			powers[i] = powers[i - 1] * 2;
		}
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < deliciousness.length; i++) {
			for (int j = 0; j < 22; j++) {
				int complement = powers[j] - deliciousness[i];
				if (hmap.containsKey(complement)) {
					count = count + hmap.get(complement);
				}
			}
			hmap.put(deliciousness[i], hmap.getOrDefault(deliciousness[i], 0) + 1);
		}
		return (int) (count % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] deliciousness = { 1, 1, 1, 3, 3, 3, 7 };
		System.out.println("Total good meals are: " + countPairsHash(deliciousness));
	}

}
