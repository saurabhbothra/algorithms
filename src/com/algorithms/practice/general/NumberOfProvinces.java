package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class NumberOfProvinces {

	// There are n cities. Some of them are connected, while some are not. If city a
	// is connected directly with city b, and city b is connected directly with city
	// c, then city a is connected indirectly with city c.

	// A province is a group of directly or indirectly connected cities and no other
	// cities outside of the group.

	// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
	// ith city and the jth city are directly connected, and isConnected[i][j] = 0
	// otherwise.

	// Return the total number of provinces.

	// dfs solution.
	public int findCircleNumDfs(int[][] isConnected) {
		int count = 0;
		boolean[] visited = new boolean[isConnected.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(isConnected, i, visited);
				count++;
			}
		}
		return count;
	}

	private void dfs(int[][] isConnected, int city, boolean[] visited) {
		visited[city] = true;
		for (int i = 0; i < visited.length; i++) {
			if (i != city) {
				if (isConnected[city][i] == 1 && !visited[i]) {
					dfs(isConnected, i, visited);
				}
			}
		}
	}

	// bfs solution.
	public int findCircleNumBfs(int[][] isConnected) {
		int count = 0;
		boolean[] visited = new boolean[isConnected.length];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				bfs(isConnected, i, visited, q);
				count++;
			}
		}
		return count;
	}

	private void bfs(int[][] isConnected, int city, boolean[] visited, ArrayDeque<Integer> q) {
		q.offer(city);
		visited[city] = true;
		while (!q.isEmpty()) {
			int poppedCity = q.poll();
			for (int i = 0; i < visited.length; i++) {
				if (i != poppedCity) {
					if (isConnected[poppedCity][i] == 1 && !visited[i]) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfProvinces np = new NumberOfProvinces();
		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println("The total number of provinces are: " + np.findCircleNumDfs(isConnected));
		System.out.println("The total number of provinces are: " + np.findCircleNumBfs(isConnected));
	}

}
