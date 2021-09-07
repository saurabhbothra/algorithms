package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CourseSchedule2 {

	// There are a total of numCourses courses you have to take, labeled from 0 to
	// numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	// [ai, bi] indicates that you must take course bi first if you want to take
	// course ai.

	// For example, the pair [0, 1], indicates that to take course 0 you have to
	// first take course 1.

	// Return the ordering of courses you should take to finish all courses. If
	// there are many valid answers, return any of them. If it is impossible to
	// finish all courses, return an empty array.

	// bfs solution using topological sorting.
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int index = 0;
		Map<Integer, List<Integer>> adj = new HashMap<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int independentCourse = prerequisites[i][1];
			int dependentCourse = prerequisites[i][0];
			inDegree[dependentCourse] = inDegree[dependentCourse] + 1;
			if (!adj.containsKey(independentCourse)) {
				adj.put(independentCourse, new ArrayList<>());
			}
			adj.get(independentCourse).add(dependentCourse);
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int poppedCourse = q.poll();
			result[index] = poppedCourse;
			index++;
			if (adj.containsKey(poppedCourse)) {
				List<Integer> childs = adj.get(poppedCourse);
				for (Integer child : childs) {
					inDegree[child] = inDegree[child] - 1;
					if (inDegree[child] == 0) {
						q.offer(child);
					}
				}
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] != 0) {
				return new int[] {};
			}
		}
		return result;
	}

	// dfs solution, using topological sorting.
	public static int[] findOrderDfs(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int index = 0;
		ArrayDeque<Integer> st = new ArrayDeque<>();
		Map<Integer, List<Integer>> adj = new HashMap<>();
		boolean[] visited = new boolean[numCourses];
		boolean[] recStk = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int independentCourse = prerequisites[i][1];
			int dependentCourse = prerequisites[i][0];
			if (!adj.containsKey(independentCourse)) {
				adj.put(independentCourse, new ArrayList<>());
			}
			adj.get(independentCourse).add(dependentCourse);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!adj.containsKey(i)) {
				adj.put(i, new ArrayList<>());
			}
			if (!visited[i]) {
				if (dfsCycle(adj, i, visited, recStk, st)) {
					return new int[] {};
				}
			}
		}
		while (!st.isEmpty()) {
			result[index] = st.pop();
			index++;
		}
		return result;
	}

	private static boolean dfsCycle(Map<Integer, List<Integer>> adj, int source, boolean[] visited, boolean[] recStk,
			ArrayDeque<Integer> st) {
		visited[source] = true;
		if (adj.containsKey(source)) {
			recStk[source] = true;
			List<Integer> childs = adj.get(source);
			for (Integer child : childs) {
				if (!visited[child]) {
					if (dfsCycle(adj, child, visited, recStk, st)) {
						return true;
					}
				} else if (recStk[child]) {
					return true;
				}
			}
			recStk[source] = false;
		}
		st.push(source);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println("The order of courses is:" + Arrays.toString(findOrder(4, prerequisites)));
		System.out.println("The order of courses is:" + Arrays.toString(findOrder(4, prerequisites)));
	}

}
