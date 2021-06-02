package com.algorithms.practice.sorting;

import java.util.Arrays;

public class MeetingMaximumGuests {

	// There is a party which starts at 0000 and ends at 2359.
	// 0 <= arr[i], dep[i] <= 2359.

	// You, along with many other guests are invited to the party. You have the
	// list of arrival and departure times of the guests. Your target is to maximum
	// guests in the party.

	// Return the maximum number of guests you can meet.

	// efficient solution.
	public static int meetMaximumGuests(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int currentCount = 1;
		int maxCount = 1;
		int i = 1;
		int j = 0;
		while (i < arr.length && j < dep.length) {
			if (arr[i] <= dep[j]) {
				currentCount++;
				i++;
			} else {
				currentCount--;
				j++;
			}
			maxCount = Math.max(currentCount, maxCount);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 900, 940 };
		int[] dep = { 1000, 1030 };
		int[] arr1 = { 800, 700, 600, 500 };
		int[] dep1 = { 840, 820, 830, 530 };
		int[] arr2 = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep2 = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("The maximum number of guests you can meet are: " + meetMaximumGuests(arr, dep));
		System.out.println("The maximum number of guests you can meet are: " + meetMaximumGuests(arr1, dep1));
		System.out.println("The maximum number of guests you can meet are: " + meetMaximumGuests(arr2, dep2));
	}

}
