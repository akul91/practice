package practice;

import java.util.Scanner;

public class MoveZeroes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int matrix[] = new int[n];
		for (int j = 0; j < n; j++)
			matrix[j] = in.nextInt();
		matrix = moveZeroesOptimized(matrix);
		for (int j = 0; j < n; j++)
			System.out.print(matrix[j] + " ");
		in.close();

	}

	public static int[] moveZeroesOptimized(int[] nums) {
		int[] count = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int zero = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] == 0)
					++zero;
			}
			count[i] = zero;
		}

		for (int i = 0; i < nums.length; i++) {
			int j = i - count[i];
			if (count[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		return nums;
	}

	public static int[] moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int x = i;
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] != 0) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						i = j;
					}
				}
				i = x;
			}
		}
		return nums;
	}
}
