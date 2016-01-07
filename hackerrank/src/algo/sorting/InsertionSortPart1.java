package algo.sorting;

import java.util.Scanner;

public class InsertionSortPart1 {

	public static void insertIntoSorted(int[] arr) {
		int n = arr.length - 1;
		for (int i = n; i > -1;) {
			int temp = arr[i], pos = i;
			boolean flag = false;
			for (int j = i - 1; j > -1; j--) {
				if (temp < arr[j]) {
					arr[j + 1] = arr[j];
					pos = j;
					flag = true;
					printArray(arr);
				} else
					arr[pos] = temp;
			}
			if (flag) {
				arr[pos] = temp;
				printArray(arr);
			} else
				--i;
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
