package com.algorithms.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheEfficient {

	// Design a data structure that follows the constraints of a Least Recently Used
	// (LRU) cache.
	// The functions get and put must each run in O(1) average time complexity.

	public int capacity;
	public int size;
	public Map<Integer, Node> hmap;
	public DoublyLinkedList cache;

	// Initialize the LRU cache with positive size capacity.
	public LRUCacheEfficient(int capacity) {
		this.capacity = capacity;
		this.size = -1;
		this.hmap = new HashMap<>();
		this.cache = new DoublyLinkedList();
	}

	// Return the value of the key if the key exists, otherwise return -1.
	public int get(int key) {
		if (!hmap.containsKey(key)) {
			return -1;
		}
		Node node = hmap.get(key);
		this.cache.changeHead(node);
		return node.data[1];
	}

	// Update the value of the key if the key exists. Otherwise, add the key-value
	// pair to the cache. If the number of keys exceeds the capacity from this
	// operation, evict the least recently used key.
	public void put(int key, int value) {
		int[] data = { key, value };
		if (hmap.containsKey(key)) {
			Node node = hmap.get(key);
			node.data = data;
			hmap.put(key, node);
			this.cache.changeHead(node);
		} else {
			Node newNode = new Node(data);
			this.hmap.put(key, newNode);
			if (this.size == this.capacity - 1) {
				Node tail = this.cache.updateTail();
				this.hmap.remove(tail.data[0]);
			} else {
				this.size++;
			}
			this.cache.addToFront(newNode);
		}
	}

	// This class represents node of a doubly linked list.
	class Node {
		public int[] data;
		public Node next;
		public Node prev;

		public Node(int[] data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	// This class represents a doubly linked list.
	class DoublyLinkedList {
		public Node head;
		public Node tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		// add a node to front.
		public void addToFront(Node node) {
			if (this.head == null) {
				this.head = node;
				this.tail = node;
			} else {
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
			}
		}

		// update head of the list.
		public void changeHead(Node node) {
			if (node == this.head) {
				return;
			}
			Node nxt = node.next;
			Node pre = node.prev;
			if (nxt == null) {
				this.tail = pre;
				node.prev = null;
				this.tail.next = null;
			} else {
				pre.next = nxt;
				nxt.prev = pre;
				node.prev = null;
			}
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}

		// delete tail and update new tail.
		public Node updateTail() {
			Node temp = this.tail;
			if (this.tail == this.head) {
				this.tail = null;
				this.head = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			temp.prev = null;
			return temp;
		}
	}

}
