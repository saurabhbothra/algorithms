package com.algorithms.practice.stack;

import java.util.Arrays;

public class KStacksInAnArray {

	// Given an array, implement k stacks in it.
	// 0 <= stackNumber <= k-1

	public int[] arr;
	public int[] prev;
	public int[] top;
	public int[] size;
	public int k;
	public int freeTop;

	public KStacksInAnArray(int capacity, int k) {
		this.k = k;
		this.arr = new int[capacity];
		this.top = new int[k];
		this.prev = new int[capacity];
		this.size = new int[k];
		for (int i = 0; i < k; i++) {
			this.top[i] = -1;
		}
		for (int i = 0; i < capacity - 1; i++) {
			this.prev[i] = i + 1;
		}
		this.prev[capacity - 1] = -1;
		this.freeTop = 0;
	}

	// push item to given stack number.
	public void push(int item, int stackNumber) {
		if (stackNumber <= 0 || stackNumber > k) {
			System.out.println("Invalid stack number.");
			return;
		}
		if (this.freeTop == -1) {
			System.out.println("Stack " + stackNumber + " Overflow.");
			return;
		}
		this.size[stackNumber - 1] = this.size[stackNumber - 1] + 1;
		int newSlot = this.prev[this.freeTop];
		this.arr[this.freeTop] = item;
		this.prev[this.freeTop] = this.top[stackNumber - 1];
		this.top[stackNumber - 1] = this.freeTop;
		this.freeTop = newSlot;
	}

	// removes and returns the top item of stack number.
	public int pop(int stackNumber) {
		if (stackNumber <= 0 || stackNumber > k) {
			System.out.println("Invalid stack number.");
			return -1;
		}
		if (this.top[stackNumber - 1] == -1) {
			System.out.println("Stack " + stackNumber + " Underflow.");
			return -1;
		}
		this.size[stackNumber - 1] = this.size[stackNumber - 1] - 1;
		int item = this.arr[this.top[stackNumber - 1]];
		this.arr[this.top[stackNumber - 1]] = -1;
		int newFutureSlot = this.prev[this.freeTop];
		this.prev[this.freeTop] = this.top[stackNumber - 1];
		int prevTop = this.top[stackNumber - 1];
		this.top[stackNumber - 1] = this.prev[prevTop];
		this.prev[prevTop] = newFutureSlot;
		return item;
	}

	// returns the top item of stack number.
	public int peek(int stackNumber) {
		if (stackNumber <= 0 || stackNumber > k) {
			System.out.println("Invalid stack number.");
			return -1;
		}
		if (this.top[stackNumber - 1] == -1) {
			System.out.println("Stack " + stackNumber + " Underflow.");
			return -1;
		}
		return this.arr[this.top[stackNumber - 1]];
	}

	// checks whether stack number is empty or not.
	public boolean isEmpty(int stackNumber) {
		if (stackNumber <= 0 || stackNumber > k) {
			System.out.println("Invalid stack number.");
			return false;
		}
		if (this.top[stackNumber - 1] == -1) {
			return true;
		}
		return false;
	}

	// returns the size of the stack number.
	public int size(int stackNumber) {
		if (stackNumber <= 0 || stackNumber > k) {
			System.out.println("Invalid stack number.");
			return -1;
		}
		return this.size[stackNumber - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KStacksInAnArray st = new KStacksInAnArray(10, 3);
		st.push(5, 1);
		st.push(10, 2);
		st.push(15, 3);
		st.push(20, 1);
		st.push(25, 2);
		st.push(30, 3);
		System.out.println(st.pop(1));
		System.out.println(st.pop(2));
		System.out.println(st.pop(3));
		System.out.println(Arrays.toString(st.arr));
		st.push(50, 1);
		st.push(60, 2);
		st.push(70, 3);
		st.push(80, 2);
		System.out.println(st.peek(1));
		System.out.println(st.peek(2));
		System.out.println(st.peek(3));
		System.out.println(Arrays.toString(st.arr));
		System.out.println(st.size(1));
		System.out.println(st.size(2));
		System.out.println(st.size(3));
	}

}
