package algo.implementation;

import java.util.Scanner;

public class ManasaAndStonesV2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int step1 = in.nextInt();
			int step2 = in.nextInt();
			int a, b;
			if (step1 > step2) {
				b = step1;
				a = step2;
			} else {
				b = step2;
				a = step1;
			}
			int difference = Math.abs(b - a);
			int min = a * (n - 1);
			int max = b * (n - 1);
			if (a == b)
				System.out.print(min);
			else {
				while (max >= min) {
					System.out.print(min + " ");
					min = min + difference;
				}
			}
			System.out.println();
		}
		in.close();

	}
}
