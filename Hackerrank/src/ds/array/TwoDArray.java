package ds.array;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				arr[arr_i][arr_j] = in.nextInt();
			}
		}
		int max = -70;
		for (int arr_i = 1; arr_i < 5; arr_i++) {
			for (int arr_j = 1; arr_j < 5; arr_j++) {
				int sum = 0;
				sum = arr[arr_i - 1][arr_j - 1] + arr[arr_i - 1][arr_j] + arr[arr_i - 1][arr_j + 1] + arr[arr_i][arr_j]
						+ arr[arr_i + 1][arr_j - 1] + arr[arr_i + 1][arr_j] + arr[arr_i + 1][arr_j + 1];
				if (sum > max) {
					max = sum;
				}
			}
		}
		System.out.print(max);
		in.close();
	}

}
