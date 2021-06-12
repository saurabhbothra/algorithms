package com.algorithms.practice.linkedlist;

// This class represents node of a circular doubly linked list. 
public class CircularDoubleNode {
	public int data;
	public CircularDoubleNode next;
	public CircularDoubleNode prev;

	public CircularDoubleNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
