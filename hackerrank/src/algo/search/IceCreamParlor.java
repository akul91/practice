package algo.search;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
				int diff = m - arr[i];
				if (diff >= 0) {
					int temp[] = new int[n];
					System.arraycopy(arr, 0, temp, 0, arr.length);
					int copy[] = new int[n];
					System.arraycopy(arr, 0, copy, 0, arr.length);
					copy[i] = -1;
					temp[i] = -1;
					Arrays.sort(copy);
					int ans = binarySearch(copy, 0, n / 2, n - 1, diff);
					if (ans != -1) {
						ans = copy[ans];
						int val = -1;
						for (int j = i + 1; j < n; j++) {
							if (temp[j] == ans) {
								val = j;
								break;
							}
						}
						System.out.println((i + 1) + " " + (val + 1));
						break;
					}
				}
			}

		}
		in.close();

	}

	public static int binarySearch(int[] arr, int start, int mid, int end, int item) {
		int index = -1;
		if (start >= end)
			return index;
		if (mid != 0)
			if ((arr[mid - 1] < item && arr[mid] > item))
				return index;
		if (mid != arr.length - 1)
			if ((arr[mid] < item && arr[mid + 1] > item))
				return index;
		if (arr[mid] == item)
			index = mid;
		else if (arr[mid] > item)
			index = binarySearch(arr, start, (start + mid) / 2, mid, item);
		else if (arr[mid] < item)
			index = binarySearch(arr, mid, (mid + end) / 2 + 1, end, item);
		return index;
	}
}
