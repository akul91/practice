package contest.weekCode19;

import java.util.Scanner;

public class CoolguyAndTwoSubsequences {

	static int[] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		long ans = 0;
		int[][] minArr = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				minArr[i][j] = findMin(i, j);

		for (int a = 0; a < n; a++) {
			for (int b = a; b < n; b++) {
				int temp = minArr[a][b];
				for (int c = b + 1; c < n; c++) {
					for (int d = c; d < n; d++) {
						ans += (long) Math.min(temp, minArr[c][d]);
					}
				}
			}
		}
		System.out.println(ans % 1000000007);
		in.close();
	}

	private static int findMin(int i, int j) {
		int min = Integer.MAX_VALUE;
		for (int x = i; x <= j; x++)
			if (arr[x] < min)
				min = arr[x];
		return min;
	}

}
