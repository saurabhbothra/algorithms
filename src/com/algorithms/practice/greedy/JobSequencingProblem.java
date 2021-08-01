package com.algorithms.practice.greedy;

import java.util.Arrays;

public class JobSequencingProblem {

	// Given a set of N jobs where each jobi has a deadline and profit associated
	// with it. Each job takes 1 unit of time to complete and only one job can be
	// scheduled at a time. We earn the profit if and only if the job is completed
	// by its deadline. The task is to find the number of jobs done and the maximum
	// profit.

	// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated
	// with that Job.

	// efficient implementation.
	public static int[] jobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (j1, j2) -> Integer.compare(-j1.profit, -j2.profit));
		int maxDeadline = 0;
		for (Job job : arr) {
			if (job.deadline > maxDeadline) {
				maxDeadline = job.deadline;
			}
		}
		int profit = 0;
		int count = 0;
		int[] sequence = new int[maxDeadline];
		for (int i = 0; i < n; i++) {
			Job job = arr[i];
			if (sequence[job.deadline - 1] == 0) {
				sequence[job.deadline - 1] = job.profit;
			} else {
				int index = job.deadline - 1;
				while (index != -1 && sequence[index] != 0) {
					index--;
				}
				if (index != -1) {
					sequence[index] = job.profit;
				}
			}
		}
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] != 0) {
				count++;
			}
			profit += sequence[i];
		}
		return new int[] { count, profit };
	}

}

class Job {
	int id;
	int profit;
	int deadline;

	Job(int id, int profit, int deadline) {
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}
}
