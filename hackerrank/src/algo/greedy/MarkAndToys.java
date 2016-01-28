package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(), k = stdin.nextInt();
		int prices[] = new int[n];
		for (int i = 0; i < n; i++)
			prices[i] = stdin.nextInt();

		int answer = 0;
		Arrays.sort(prices);
		for (int i = 0; i <= n; i++) {
			k -= prices[i];
			if (k >= 0)
				answer++;
			else
				break;
		}
		System.out.println(answer);
		stdin.close();

	}

}
