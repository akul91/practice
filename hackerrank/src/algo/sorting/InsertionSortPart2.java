package algo.sorting;

import java.util.Scanner;

public class InsertionSortPart2 {

	public static void insertionSortPart2(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int val = arr[i];
			for (int j = i; j > 0; j--) {
				if (val < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
			printArray(arr);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);
		in.close();

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
