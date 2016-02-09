package algo.sorting;

import java.util.Scanner;

public class Quicksort2Sorting {

	static int[] ar;

	static int partition(int start, int end) {
		int pivot = ar[start];
		int pos = start;
		for (int i = start + 1; i < end; i++) {
			if (ar[i] < pivot) {
				++pos;
				int temp = ar[i];
				for (int j = i; j >= pos; j--) {
					ar[j] = ar[j - 1];
				}
				ar[pos] = temp;
			}
		}
		for (int i = start; i < pos; i++)
			ar[i] = ar[i + 1];
		ar[pos] = pivot;
		return pos;
	}

	static void quickSort(int start, int end) {
		if (start >= end-1)
			return;
		int pos = partition(start, end);
		quickSort(start, pos);
		quickSort(pos + 1, end);
		printArray(start, end);
	}

	static void printArray(int start, int end) {
		for (int n = start; n < end; n++)
			System.out.print(ar[n] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ar = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = in.nextInt();
		quickSort(0, ar.length);
		in.close();
	}
}