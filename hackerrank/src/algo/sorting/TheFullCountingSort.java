package algo.sorting;

import java.util.Scanner;

public class TheFullCountingSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Object grid[][] = new Object[100][2];
		for (int i = 0; i < 100; i++) {
			grid[i][0] = 0;
			grid[i][1] = new StringBuffer("");
		}
		for (int input = 0; input < n; input++) {
			int val = in.nextInt();
			StringBuffer str = new StringBuffer(in.next());
			grid[val][0] = (int) grid[val][0] + 1;
			if (input >= n / 2)
				((StringBuffer) grid[val][1]).append(str + " ");
			else
				((StringBuffer) grid[val][1]).append("- ");
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < 100; i++)
			str.append(grid[i][1]);
		System.out.println(str);
		in.close();
	}
}
