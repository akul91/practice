package algo.sorting;

import java.util.Scanner;

public class RunningTimeofAlgorithms {

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		int count=0;
		for (int i = 1; i < n; i++) {
			int val = arr[i];
			for (int j = i; j > 0; j--) {
				if (val < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					++count;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
		in.close();

	}

}
