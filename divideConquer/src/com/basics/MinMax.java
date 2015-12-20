package com.basics;

public class MinMax {

	static int min;
	static int max;
	static int[] arr = new int[2]; // 0 is min, 1 is max

	public static void main(String[] args) {

		int n = (int) (Math.random() * 10);

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * 1000);
			System.out.print(a[i] + " ");
		}
		arr[0] = arr[1] = min = max = a[0];
		System.out.println("\nMin is:" + min(a, 0, a.length - 1));
		System.out.println("Max is:" + max(a, 0, a.length - 1));

		arr = minmax(a, 0, a.length - 1);
		System.out.println(arr[0] + " " + arr[1]);

	}

	private static int[] minmax(int[] a, int start, int end) {
		if (start == end - 1 || start > end - 1) {
			if (arr[1] < a[end]) {
				arr[1] = a[end];
			} else if (arr[1] < a[start]) {
				arr[1] = a[start];
			}
			if (arr[0] > a[end]) {
				arr[0] = a[end];
			} else if (arr[0] > a[start]) {
				arr[0] = a[start];
			}
			return arr;
		}
		int mid = (start + end) / 2;
		minmax(a, start, mid);
		minmax(a, mid + 1, end);

		return arr;
	}

	private static int max(int[] a, int start, int end) {
		if (start == end - 1 || start > end - 1) {
			if (max < a[end]) {
				max = a[end];
			} else if (max < a[start]) {
				max = a[start];
			}
			return max;
		}
		int mid = (start + end) / 2;
		max(a, start, mid);
		max(a, mid + 1, end);

		return max;
	}

	private static int min(int[] a, int start, int end) {
		if (start == end - 1 || start > end - 1) {
			if (min > a[end]) {
				min = a[end];
			} else if (min > a[start]) {
				min = a[start];
			}
			return min;
		}
		int mid = (start + end) / 2;
		min(a, start, mid);
		min(a, mid + 1, end);

		return min;
	}

}
