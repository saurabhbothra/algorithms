package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

// Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, 
// and small, with a fixed number of slots for each size.

public class DesignParkingSystem {
	public Map<Integer, Integer> hmap;

	// Initializes object of the ParkingSystem class. The number of slots for each
	// parking space are given as part of the constructor.
	public DesignParkingSystem(int big, int medium, int small) {
		this.hmap = new HashMap<>();
		hmap.put(1, big);
		hmap.put(2, medium);
		hmap.put(3, small);
	}

	// Checks whether there is a parking space of carType for the car that wants to
	// get into the parking lot. carType can be of three kinds: big, medium, or
	// small, which are represented by 1, 2, and 3 respectively. A car can only park
	// in a parking space of its carType. If there is no space available, return
	// false, else park the car in that size space and return true.
	public boolean addCar(int carType) {
		if (hmap.get(carType) == 0) {
			return false;
		}
		hmap.put(carType, hmap.get(carType) - 1);
		return true;
	}
}
