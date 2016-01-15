package algo.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KDifference {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int index = 0; index < n; index++) {
			a[index] = in.nextInt();
		}
		int k = in.nextInt();
		System.out.print(KDifference(a, k));
		in.close();
	}

	static int KDifference(int[] a, int k) {
		// Sorting the array in O(nlogn) time
		Arrays.sort(a);
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			// Checking the difference
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] - a[i] == k)
					++count;
				// Breaking if difference is more than the required difference
				else if (a[j] - a[i] > k)
					break;
			}
		}
		return count;
	}
}
