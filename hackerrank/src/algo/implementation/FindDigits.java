package algo.implementation;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int copy = n;
			int count = 0;
			while (n != 0) {
				int num = n % 10;
				n = n / 10;
				if (num != 0 && copy % num == 0)
					count++;
			}
			System.out.println(count);
		}
		in.close();
	}

}
