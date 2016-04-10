package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(), count = 0;
		int weight[] = new int[n];
		for (int i = 0; i < n; i++)
			weight[i] = stdin.nextInt();

		while (!check(weight) && n > 0) {
			Arrays.sort(weight);
			int val = weight[0];
			++count;
			for (int i = 0; i < n; i++) {
				if (weight[i] <= val + 4)
					weight[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < n; i++)
				System.out.print(weight[i] + " ");
			System.out.println();
		}
		System.out.println(count);
		stdin.close();
	}

	private static boolean check(int[] weight) {
		for (int i = 0; i < weight.length; i++) {
			if (weight[i] != Integer.MAX_VALUE)
				return false;
		}
		return true;
	}

}
