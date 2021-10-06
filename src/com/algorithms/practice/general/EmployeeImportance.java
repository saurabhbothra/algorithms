package com.algorithms.practice.general;

import java.util.List;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.HashMap;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class EmployeeImportance {

	// You have a data structure of employee information, which includes the
	// employee's unique id, their importance value, and their direct subordinates'
	// id.

	// You are given an array of employees employees where:

	// employees[i].id is the ID of the ith employee.
	// employees[i].importance is the importance value of the ith employee.
	// employees[i].subordinates is a list of the IDs of the subordinates of the ith
	// employee.
	// Given an integer id that represents the ID of an employee, return the total
	// importance value of this employee and all their subordinates.

	// One employee has at most one direct leader and may have several subordinates.
	// id is guaranteed to be a valid employee id.

	// bfs solution.
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Integer> importanceValues = new HashMap<>();
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		int result = 0;
		for (Employee e : employees) {
			importanceValues.put(e.id, e.importance);
			hmap.put(e.id, e.subordinates);
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(id);
		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			result += importanceValues.get(poppedNode);
			List<Integer> childs = hmap.get(poppedNode);
			if (childs.size() != 0) {
				for (Integer child : childs) {
					q.offer(child);
				}
			}
		}

		return result;
	}

	// dfs solution.
	public int getImportanceDfs(List<Employee> employees, int id) {
		Map<Integer, Integer> importanceValues = new HashMap<>();
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		for (Employee e : employees) {
			importanceValues.put(e.id, e.importance);
			hmap.put(e.id, e.subordinates);
		}
		return dfs(hmap, importanceValues, id);
	}

	private int dfs(Map<Integer, List<Integer>> hmap, Map<Integer, Integer> importanceValues, int source) {
		int res = importanceValues.get(source);
		List<Integer> childs = hmap.get(source);
		if (childs.size() != 0) {
			for (Integer child : childs) {
				res += dfs(hmap, importanceValues, child);
			}
		}
		return res;
	}
}
