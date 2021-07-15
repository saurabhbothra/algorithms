package com.algorithms.practice.heap;

public class BinaryHeapImplementation {

	// Implement your own min heap.

	public int[] arr;
	public int size;

	// initialize your data structure.
	public BinaryHeapImplementation(int capacity) {
		this.arr = new int[capacity];
		this.size = 0;
	}

	// get index of left child of node at index i.
	public int left(int i) {
		return (2 * i) + 1;
	}

	// get index of right child of node at index i.
	public int right(int i) {
		return (2 * i) + 2;
	}

	// get index of parent of node at index i.
	public int parent(int i) {
		return (i - 1) / 2;
	}

	// binary heap insert operation.
	public void insert(int key) {
		if (this.size == this.arr.length) {
			return;
		}
		this.arr[this.size] = key;
		this.size++;
		int index = this.size - 1;
		int parent = this.parent(index);
		while (index != 0 && this.arr[parent] > this.arr[index]) {
			int temp = this.arr[parent];
			this.arr[parent] = this.arr[index];
			this.arr[index] = temp;
			index = parent;
			parent = this.parent(index);
		}
	}

	// traverse min heap.
	public void display() {
		for (int i = 0; i < this.size; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}

	// heapify operation for min heap.
	public void minHeapify(int i) {
		if (i >= this.size && i < 0) {
			return;
		}
		int left = this.left(i);
		int right = this.right(i);
		int temp = i;
		if (left < this.size && this.arr[i] > this.arr[left]) {
			temp = left;
		}
		if (right < this.size && this.arr[temp] > this.arr[right]) {
			temp = right;
		}
		if (temp == i) {
			return;
		}
		int s = this.arr[i];
		this.arr[i] = this.arr[temp];
		this.arr[temp] = s;
		minHeapify(temp);
	}

	// extract min for min heap.
	public int extractMin() {
		if (this.size == 0) {
			return -1;
		}
		int item = this.arr[0];
		if (this.size == 1) {
			this.size--;
			return item;
		}
		this.arr[0] = this.arr[this.size - 1];
		this.size--;
		minHeapify(0);
		return item;
	}

	// decrease key operation for min heap.
	public void decreaseKey(int i, int key) {
		if (this.size == 0 || i < 0 || i >= this.size) {
			return;
		}
		this.arr[i] = key;
		int parent = this.parent(i);
		while (i != 0 && this.arr[parent] > this.arr[i]) {
			int temp = this.arr[parent];
			this.arr[parent] = this.arr[i];
			this.arr[i] = temp;
			i = parent;
			parent = this.parent(i);
		}
	}

	// delete operation for min heap.
	public void delete(int i) {
		if (this.size == 0 || i < 0 || i >= this.size) {
			return;
		}
		this.decreaseKey(i, Integer.MIN_VALUE);
		this.extractMin();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryHeapImplementation minHeap = new BinaryHeapImplementation(10);
		minHeap.insert(40);
		minHeap.insert(30);
		minHeap.insert(20);
		minHeap.insert(10);
		minHeap.insert(50);
		System.out.println("The min heap elements are:");
		minHeap.display();
	}

}
