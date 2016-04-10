package algo.dp;

import java.util.Arrays;
import java.util.Scanner;

public class TheMaximumSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			long c = 0, nc = 0, maxSum = Long.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int[] copy = arr.clone();
			Arrays.sort(copy);
			boolean flag = false;
			if (copy[arr.length - 1] < 0) {
				nc = copy[arr.length - 1];
				maxSum = copy[arr.length - 1];
				flag = true;
			}
			if (!flag) {
				for (int j = 0; j < n; j++) {
					if (arr[j] > 0)
						nc += arr[j];
					c += arr[j];
					if (c < 0)
						c = 0;
					if (maxSum < c)
						maxSum = c;
				}
			}
			System.out.println(maxSum + " " + nc);
		}
		sc.close();
	}

}
