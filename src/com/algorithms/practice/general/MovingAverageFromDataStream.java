package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class MovingAverageFromDataStream {

	// Given a stream of integers and a window size, calculate the moving average of
	// all integers in the sliding window.

	public int sum;
	public int size;
	public ArrayDeque<Integer> q;

	// MovingAverage(int size) Initializes the object with the size of the window
	// size.
	public MovingAverageFromDataStream(int size) {
		this.size = size;
		this.sum = 0;
		this.q = new ArrayDeque<>();
	}

	// double next(int val) Returns the moving average of the last size values of
	// the stream.
	public double next(int val) {
		sum = sum + val;
		q.offer(val);
		if (q.size() > size) {
			sum = sum - q.poll();
		}
		return (double) sum / q.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverageFromDataStream movingAverage = new MovingAverageFromDataStream(3);
		movingAverage.next(1); // return 1.0 = 1 / 1
		movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
		movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
	}

}
