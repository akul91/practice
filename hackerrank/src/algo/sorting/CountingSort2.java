package algo.sorting;

import java.util.Scanner;

public class CountingSort2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int grid[] = new int[100];
		for (int input = 0; input < n; input++) {
			int val = in.nextInt();
			grid[val] += 1;
		}
		for (int i = 0; i < 100; i++) {
			if (grid[i] != 0)
				for (int j = 0; j < grid[i]; j++)
					System.out.print(i + " ");
		}
		in.close();
	}
}
