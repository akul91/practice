package algo.string;

import java.util.Scanner;

public class CommonChild {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		int len = s1.length();
		int[][] matrix = new int[len + 1][len + 1];
		for (int i = 1; i < len + 1; i++) {
			for (int j = 1; j < len + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				else
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
			}
		}
		System.out.println(matrix[len][len]);
		in.close();
	}
}
