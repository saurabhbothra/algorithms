package com.algorithms.practice.stack;

public class TwoStacksInAnArray {

	// We are given an array, implement two stacks in it.

	public int[] arr;
	public int top1;
	public int top2;

	public TwoStacksInAnArray(int capacity) {
		this.arr = new int[capacity];
		this.top1 = -1;
		this.top2 = capacity;
	}

	// pushes item to stack 1.
	public void push1(int item) {
		if (this.top1 + 1 == this.top2) {
			System.out.println("Stack1 Overflow.");
			return;
		}
		this.top1++;
		this.arr[top1] = item;
	}

	// pushes item to stack 2.
	public void push2(int item) {
		if (this.top2 - 1 == this.top1) {
			System.out.println("Stack2 Overflow.");
			return;
		}
		this.top2--;
		this.arr[this.top2] = item;
	}

	// removes and returns top item of stack 1.
	public int pop1() {
		if (this.top1 == -1) {
			System.out.println("Stack1 Underflow.");
			return -1;
		}
		int item = this.arr[this.top1];
		this.top1--;
		return item;
	}

	// removes and returns top item of stack 2.
	public int pop2() {
		if (this.top2 == this.arr.length) {
			System.out.println("Stack2 Underflow.");
			return -1;
		}
		int item = this.arr[this.top2];
		this.top2++;
		return item;
	}

	// returns the size of stack 1.
	public int size1() {
		return this.top1 + 1;
	}

	// returns the size of stack 2.
	public int size2() {
		return this.arr.length - this.top2;
	}

	// returns the top item of stack 1.
	public int peek1() {
		if (this.top1 == -1) {
			System.out.println("Stack1 Underflow.");
			return -1;
		}
		return this.arr[this.top1];
	}

	// returns the top item of stack 2.
	public int peek2() {
		if (this.top2 == this.arr.length) {
			System.out.println("Stack2 Underflow.");
			return -1;
		}
		return this.arr[this.top2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStacksInAnArray st = new TwoStacksInAnArray(5);
		st.push1(5);
		st.push2(10);
		st.push1(6);
		st.push2(11);
		st.push1(67);
		System.out.println(st.pop1());
		System.out.println(st.pop2());
		System.out.println(st.peek1());
		System.out.println(st.peek2());
	}

}
