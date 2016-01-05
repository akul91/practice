package algo.implementation;

import java.util.Scanner;

public class CutTheSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		while (!check(arr)) {
			int min = 1001;
			for (int index = 0; index < arr.length; index++)
				if (arr[index] < min && arr[index] != 0)
					min = arr[index];
			int count = 0;
			for (int index = 0; index < arr.length; index++) {
				if (arr[index] != 0) {
					arr[index] -= min;
					++count;
				}
			}
			System.out.println(count);
		}
		in.close();
	}

	private static boolean check(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

}
