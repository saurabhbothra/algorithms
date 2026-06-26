package com.algorithms.practice.arrays;

public class MinimumConsecutiveFlips {

	// We are given a binary array. make all elements of the binary array same
	// either by flipping all zero's or all one's.
	// We are allowed to consecutive flips in one go.
	// We need to find out minimum number of flips required to make all array
	// elements same.

    public static int minimumConsecutiveFlipsCount(int[] arr) {
        int onesGroup = 0;
        int zeroGroup = 0;
        int curr = arr[0];
        if (arr[0] == 0) {
            zeroGroup++;
        } else {
            onesGroup++;
        }
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] != curr) {
                curr = arr[i];
                if(arr[i] == 0) {
                    zeroGroup++;
                } else  {
                    onesGroup++;
                }
            }
        }
        return Math.min(onesGroup, zeroGroup);
    }

	// efficient solution, in one traversal.
	public static void minimumConsecutiveFlips(int[] arr) {
		if (arr.length == 0) {
			System.out.println("No flips required.");
			return;
		}
		int firstElement = arr[0];
		int start = 0;
		int end = arr.length - 1;
		boolean flag = false;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != firstElement) {
				if (!flag) {
					flag = true;
					start = i;
				}
			} else {
				if (flag) {
					flag = false;
					end = i - 1;
					System.out.println("From " + start + " to " + end);
				}
			}
		}
		if(start == end || end == arr.length - 1) {
			System.out.println("From " + start + " to " + end);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 0, 0, 0, 1 };
		int[] arr1 = { 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1 };
		int[] arr2 = { 0, 0, 1, 1, 0, 0, 1, 1, 0 };
        int[] arr3 = { 1, 1, 1 };
        int[] arr4 = { 0, 1 };
		System.out.println("The minimum consecutive flips for this array are: ");
		minimumConsecutiveFlips(arr);
        System.out.println();
        System.out.println("The minimum consecutive flips count for this array are: " +  minimumConsecutiveFlipsCount(arr));
        System.out.println("The minimum consecutive flips count for this array are: " +  minimumConsecutiveFlipsCount(arr1));
        System.out.println("The minimum consecutive flips count for this array are: " +  minimumConsecutiveFlipsCount(arr2));
        System.out.println("The minimum consecutive flips count for this array are: " +  minimumConsecutiveFlipsCount(arr3));
        System.out.println("The minimum consecutive flips count for this array are: " +  minimumConsecutiveFlipsCount(arr4));
	}

}
