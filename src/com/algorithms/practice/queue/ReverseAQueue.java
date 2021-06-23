package com.algorithms.practice.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseAQueue {

	// Given a queue, reverse it.

	// iterative solution.
	public static void reverseIterative(Queue<Integer> q) {
		ArrayDeque<Integer> st = new ArrayDeque<>();
		while (!q.isEmpty()) {
			st.push(q.poll());
		}
		while (!st.isEmpty()) {
			q.offer(st.pop());
		}
	}

	// recursive solution.
	public static void reverseRec(Queue<Integer> q) {
		if (q.isEmpty()) {
			return;
		}
		int item = q.poll();
		reverseRec(q);
		q.offer(item);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(10);
		q.offer(5);
		q.offer(15);
		q.offer(20);
		System.out.println("Queue before reverse is: " + q);
		reverseRec(q);
		System.out.println("Queue after reverse is: " + q);
	}

}
