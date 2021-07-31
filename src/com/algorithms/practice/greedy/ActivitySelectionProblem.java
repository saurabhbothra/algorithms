package com.algorithms.practice.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ActivitySelectionProblem {

	// Given N activities with their start and finish day given in array start[ ]
	// and end[ ]. Select the maximum number of activities that can be performed by
	// a single person, assuming that a person can only work on a single activity at
	// a given day.
	// Note : Duration of the activity includes both starting and ending day.

	// efficient implementation.
	public static int activitySelection(int start[], int end[], int n) {
		Activity[] activities = new Activity[n];
		for (int i = 0; i < n; i++) {
			activities[i] = new Activity(start[i], end[i]);
		}
		Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.end, a2.end));
		ArrayDeque<Activity> st = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (!st.isEmpty()) {
				if (activities[i].start > st.peek().end) {
					st.push(activities[i]);
				}
			} else {
				st.push(activities[i]);
			}
		}
		return st.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = { 2, 10, 3, 1 };
		int[] end = { 4, 11, 8, 3 };
		System.out.println("The maximum number of activities you can do is: " + activitySelection(start, end, 4));
	}

}

class Activity {
	int start;
	int end;

	Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
