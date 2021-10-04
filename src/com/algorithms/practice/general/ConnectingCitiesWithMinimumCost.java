package com.algorithms.practice.general;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

class PNode {
	int data;
	int weight;

	PNode(int data, int weight) {
		this.data = data;
		this.weight = weight;
	}
}

public class ConnectingCitiesWithMinimumCost {

	// There are n cities labeled from 1 to n. You are given the integer n and an
	// array connections where connections[i] = [xi, yi, costi] indicates that the
	// cost of connecting city xi and city yi (bidirectional connection) is costi.

	// Return the minimum cost to connect all the n cities such that there is at
	// least one path between each pair of cities. If it is impossible to connect
	// all the n cities, return -1,

	// The cost is the sum of the connections' costs used.

	// using prim's algorithm.
	public int minimumCost(int n, int[][] connections) {
		boolean[] visited = new boolean[n + 1];
		Map<Integer, List<List<Integer>>> hmap = new HashMap<>();
		for (int i = 0; i < connections.length; i++) {
			int src = connections[i][0];
			int des = connections[i][1];
			int wt = connections[i][2];
			if (!hmap.containsKey(src)) {
				hmap.put(src, new ArrayList<>());
			}
			if (!hmap.containsKey(des)) {
				hmap.put(des, new ArrayList<>());
			}
			List<Integer> temp1 = new ArrayList<>();
			List<Integer> temp2 = new ArrayList<>();
			temp1.add(des);
			temp1.add(wt);
			temp2.add(src);
			temp2.add(wt);
			hmap.get(src).add(temp1);
			hmap.get(des).add(temp2);
		}
		int res = 0;
		PriorityQueue<PNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
		pq.offer(new PNode(1, 0));
		while (!pq.isEmpty()) {
			PNode poppedNode = pq.poll();
			if (visited[poppedNode.data]) {
				continue;
			}
			res = res + poppedNode.weight;
			visited[poppedNode.data] = true;
			if (hmap.containsKey(poppedNode.data)) {
				List<List<Integer>> childs = hmap.get(poppedNode.data);
				if (childs.size() != 0) {
					for (List<Integer> child : childs) {
						int node = child.get(0);
						int wt = child.get(1);
						if (!visited[node]) {
							pq.offer(new PNode(node, wt));
						}
					}
				}
			}
		}
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				return -1;
			}
		}
		return res;
	}

}
