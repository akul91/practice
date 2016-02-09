package algo.sorting;

import java.util.Scanner;

public class Quicksort1Partition {

	static void partition(int[] ar) {
		int pivot = ar[0];
		int pos = 0;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < pivot) {
				++pos;
				int temp = ar[i];
				for (int j = i; j >= pos; j--)
					ar[j] = ar[j - 1];
				ar[pos] = temp;
			}
		}
		for (int i = 0; i < pos; i++)
			ar[i] = ar[i + 1];
		ar[pos] = pivot;
		printArray(ar);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
		in.close();
	}
}
