package algo.dp;

import java.util.Scanner;

public class StockMaximize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int[] max = new int[n];
			for (int j = 0; j < n;) {
				int pos = -1;
				for (int k = j + 1; k < n; k++) {
					int temp = 0;
					temp = arr[k] - arr[j];
					if (temp > 0 && max[j] < temp) {
						max[j] = temp;
						pos = k;
					}
				}
				if (pos != -1) {
					while (j < pos) {
						j++;
						max[j] = arr[pos] - arr[j];
					}
				} else
					++j;
			}
			long sum = 0;
			for (int j = 0; j < n; j++)
				sum += (long) max[j];
			System.out.println(sum);
		}
		sc.close();
	}

}
