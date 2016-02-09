package algo.sorting;

import java.util.Scanner;

public class RunningTimeQuicksort {

	static int insertionSwaps = 0;
	static int quickSwaps = 0;
	static int[] ar;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		ar = new int[s];
		int[] arr = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
			arr[i] = ar[i];
		}
		insertionSort(arr);
		quickSort(0, ar.length);
		System.out.println(insertionSwaps - quickSwaps);
		in.close();

	}

	static void printArray(int start, int end) {
		for (int n = start; n < end; n++)
			System.out.print(ar[n] + " ");
		System.out.println("");
	}

	static int partition(int start, int end) {
		int pivot = ar[end - 1];
		int pos = start;
		boolean swap = false;
		for (int i = start; i < end - 1; i++) {
			if (ar[i] <= ar[end - 1]) {
				swap = true;
			}
			if (ar[i] <= ar[end - 1]) {
				if (swap) {
					int temp = ar[i];
					ar[i] = ar[pos];
					ar[pos] = temp;
					swap = false;
				}
				++quickSwaps;
				++pos;
			} else if (ar[i] > ar[end - 1]) {
				swap = true;
			}
		}
		if (ar[end - 2] > ar[end - 1]) {
			int temp = ar[end - 1];
			ar[end - 1] = ar[pos];
			ar[pos] = temp;
			++quickSwaps;
		}
		if (pivot == ar[end - 1])
			++quickSwaps;
		return pos;
	}

	static void quickSort(int start, int end) {
		if (start >= end - 1)
			return;
		int pos = partition(start, end);
		quickSort(start, pos);
		quickSort(pos + 1, end);
	}

	public static void insertionSort(int[] ar) {
		int n = ar.length;
		for (int i = 1; i < n; i++) {
			int val = ar[i];
			for (int j = i; j > 0; j--) {
				if (val < ar[j - 1]) {
					++insertionSwaps;
					int temp = ar[j];
					ar[j] = ar[j - 1];
					ar[j - 1] = temp;
				}
			}
		}
	}

}
