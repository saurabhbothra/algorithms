package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class PairOfSongs {

	// You are given a list of songs where the ith song has a duration of time[i]
	// seconds.

	// Return the number of pairs of songs for which their total duration in seconds
	// is divisible by 60. Formally, we want the number of indices i, j such that i
	// < j with (time[i] + time[j]) % 60 == 0.

	// 1 <= time.length <= 6 * 104
	// 1 <= time[i] <= 500

	// solution, making use of constraints.
	public static int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < time.length; i++) {
			for (int j = 1; j <= 16; j++) {
				if (hmap.containsKey((j * 60) - time[i])) {
					count = count + hmap.get((j * 60) - time[i]);
				}
			}
			hmap.put(time[i], hmap.getOrDefault(time[i], 0) + 1);
		}
		return count;
	}

	// solution using modulo property.
	// (a + b) % 60 = [(a % 60) + (b % 60)] % 60 ---> this expression should be
	// zero.
	// either both a % 60 and b % 60 are zero or (a % 60 + b % 60] = 60
	public static int numPairsDivisibleBy60Mod(int[] time) {
		int count = 0;
		int[] arr = new int[60];
		for (int i = 0; i < time.length; i++) {
			int mod = time[i] % 60;
			if (mod == 0) {
				count = count + arr[0];
			} else {
				count = count + arr[60 - mod];
			}
			arr[mod] += 1;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] time = { 30, 20, 150, 100, 40 };
		System.out.println("The number of song pairs are: " + numPairsDivisibleBy60(time));
		System.out.println("The number of song pairs are: " + numPairsDivisibleBy60Mod(time));
	}

}
