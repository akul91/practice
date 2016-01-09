package algo.implementation;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			int wrappers;
			int count = wrappers = n / c;
			while (wrappers / m != 0) {
				int extra = wrappers / m;
				count += extra;
				wrappers = extra + (wrappers % m);
			}
			System.out.println(count);
		}
		in.close();
	}
}
