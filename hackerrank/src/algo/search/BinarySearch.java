package algo.search;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		int item = in.nextInt();
		System.out.println(binarySearch(arr, 0, n / 2, n - 1, item));
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