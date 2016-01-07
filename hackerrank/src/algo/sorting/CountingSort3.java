package algo.sorting;

import java.util.Scanner;

public class CountingSort3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int grid[] = new int[100];
		for (int input = 0; input < n; input++) {
			int val = in.nextInt();
			String str=in.next();
			grid[val] += 1;
		}
		int count=0;
		for (int i = 0; i < 100; i++) {
			count+=grid[i];
			System.out.print(count + " ");
		}
		in.close();
	}
}
