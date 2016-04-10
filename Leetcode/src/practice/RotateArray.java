/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].*/
package practice;

import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int matrix[] = new int[n];
		for (int j = 0; j < n; j++)
			matrix[j] = in.nextInt();
		int r = in.nextInt();
		matrix = rotateOptimized(matrix, r);
		for (int j = 0; j < n; j++)
			System.out.print(matrix[j] + " ");
		in.close();
	}

	public static int[] rotateOptimized(int[] nums, int k) {
		k = k % nums.length;
		int[] matrix = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int newPos = i + k ;
			if (newPos > nums.length - 1)
				newPos = newPos - nums.length;
			matrix[newPos] = nums[i];
		}
		return matrix;
	}

	public static int[] rotate(int[] nums, int k) {
		k = k % nums.length;
		for (int r = 0; r < k; r++) {
			for (int i = nums.length - 1; i > 0; i--) {
				if (i == nums.length - 1)
					nums = swap(nums, i, 0);
				else
					nums = swap(nums, i, i + 1);
			}
		}
		return nums;
	}

	private static int[] swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}
}
