package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			for (int j = 0; j < n; j++)
				a[j] = in.nextInt();
			for (int j = 0; j < n; j++)
				b[j] = in.nextInt();
			boolean flag = true;
			Arrays.sort(b);
			Arrays.sort(a);
			for (int j = 0, x = n - 1; j < n && x > 0; j++, x--) {
				if (a[j] + b[x] < k) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();

	}
}
