package com.algorithms.practice.general;

import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeKSortedLists {

	// You are given an array of k linked-lists lists, each linked-list is sorted in
	// ascending order.

	// Merge all the linked-lists into one sorted linked-list and return it.

	// efficient solution.
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		if (k == 0) {
			return null;
		}
		ListNode head = null;
		ListNode tail = null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
		for (int i = 0; i < k; i++) {
			if (lists[i] != null) {
				pq.add(lists[i]);
			}
		}
		while (!pq.isEmpty()) {
			ListNode poppedNode = pq.poll();
			if (head == null) {
				head = poppedNode;
				tail = poppedNode;
			} else {
				tail.next = poppedNode;
				tail = poppedNode;
			}
			if (poppedNode.next != null) {
				pq.offer(poppedNode.next);
			}
		}
		if (tail != null) {
			tail.next = null;
		}
		return head;
	}

}
