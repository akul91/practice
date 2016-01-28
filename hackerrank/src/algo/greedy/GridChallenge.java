package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int index = 0; index < t; index++) {
			int n = in.nextInt();
			char[][] matrix = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = in.next();
				matrix[i] = str.toCharArray();
				Arrays.sort(matrix[i]);
			}
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					if ((int) matrix[i][j] > (int) matrix[i + 1][j]) {
						flag = false;
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
