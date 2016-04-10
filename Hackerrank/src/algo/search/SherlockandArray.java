package algo.search;

import java.util.Scanner;

public class SherlockandArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			boolean flag = false;
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			if (n == 1)
				flag = true;
			else {
				long arrL[] = new long[n];
				arrL[0] = arr[0];
				for (int i = 1; i < n; i++) {
					arrL[i] = arrL[i - 1] + arr[i];
				}
				long arrR[] = new long[n];
				arrR[n - 1] = arr[n - 1];
				for (int i = n - 2; i >= 0; i--) {
					arrR[i] = arrR[i + 1] + arr[i];
				}
				for (int j = 1; j < n - 1; j++) {
					if (arrL[j - 1] == arrR[j + 1]) {
						flag = true;
						break;
					}
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
