package basic;

import java.util.Arrays;

public class TwoMins {

	static int[] arr = new int[2]; // 0 is min, 1 is secondmin

	public static void main(String[] args) {

		int n = (int) (Math.random() * 10) + 3;

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * 100000);
			System.out.print(a[i] + " ");
		}

		arr[0] = Math.min(a[0], a[1]);
		arr[1] = Math.max(a[0], a[1]);

		arr = twoMins(a, 0, a.length - 1);
		System.out.println("\n" + arr[0] + " " + arr[1]);

		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	private static int[] twoMins(int[] a, int start, int end) {
		if (start == end - 1 || start > end - 1) {
			int temp, temp1;
			if (a[start] > a[end]) {
				temp = a[end];
				temp1 = a[start];
			} else {
				temp1 = a[end];
				temp = a[start];
			}
			if (arr[0] > temp) {
				if (arr[1] > temp)
					if (arr[0] > temp1 && temp != temp1)
						arr[1] = temp1;
					else
						arr[1] = arr[0];
				arr[0] = temp;
			} else if (arr[1] > temp && temp != arr[0])
				arr[1] = temp;

			return arr;
		}
		int mid = (start + end) / 2;
		twoMins(a, start, mid);
		twoMins(a, mid + 1, end);

		return arr;
	}
}
