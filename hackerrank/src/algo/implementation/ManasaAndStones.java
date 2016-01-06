package algo.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManasaAndStones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int length = (int) Math.pow(2, n - 1);
			int matrix[][] = new int[length][n];
			int val = length / 2;
			for (int i = 1; i < n; i++) {
				boolean gate = false;
				int count = 0;
				for (int j = 0; j < length; j++) {
					++count;
					if (!gate)
						matrix[j][i] = matrix[j][i - 1] + a;
					else
						matrix[j][i] = matrix[j][i - 1] + b;
					if (count % val == 0) {
						count = 0;
						if (gate)
							gate = false;
						else
							gate = true;
					}
				}
				val = val / 2;
			}
			List<Integer> output = new ArrayList<Integer>();
			for (int i = 0; i < length; i++) {
				if (!output.contains(matrix[i][n - 1])) {
					output.add(matrix[i][n - 1]);
					System.out.print(matrix[i][n - 1] + " ");
				}
			}
			System.out.println();
		}
		in.close();
	}
}
