package com.algorithms.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class RobotBoundedInACircle {

	// On an infinite plane, a robot initially stands at (0, 0) and faces north. The
	// robot can receive one of three instructions:

	// "G": go straight 1 unit;
	// "L": turn 90 degrees to the left;
	// "R": turn 90 degrees to the right.
	// The robot performs the instructions given in order, and repeats them forever.

	// Return true if and only if there exists a circle in the plane such that the
	// robot never leaves the circle.

	// efficient solution.
	public static boolean isRobotBounded(String instructions) {
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			hmap.put(i, 0);
		}
		int currDirection = computeInstruction(instructions, hmap, 0);
		int diff = Math.abs(hmap.get(0) - hmap.get(2)) + Math.abs(hmap.get(1) - hmap.get(3));
		if (currDirection == 0 && diff > 0) {
			return false;
		}
		return true;
	}

	public static int computeInstruction(String instructions, Map<Integer, Integer> hmap, int currDirection) {
		for (int i = 0; i < instructions.length(); i++) {
			if (instructions.charAt(i) == 'G') {
				hmap.put(currDirection, hmap.get(currDirection) + 1);
			} else if (instructions.charAt(i) == 'L') {
				currDirection = (currDirection + 1) % 4;
			} else {
				currDirection = (currDirection + 3) % 4;
			}
		}
		return currDirection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is Robot Bounded in A Circle: " + isRobotBounded("GGLLGG"));

	}

}
