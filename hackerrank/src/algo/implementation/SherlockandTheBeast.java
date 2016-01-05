package algo.implementation;

import java.util.Scanner;

public class SherlockandTheBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(check(n));
		}
		in.close();
	}

	private static String check(int n) {
		String val = new String("-1");
		int copy = n;
		while (n > 0) {
			if (n % 3 == 0)
				break;
			else
				n -= 5;
		}
		if (n >= 0) {
			val = new String();
			for (int i = 0; i < n / 3; i++)
				val = 555 + val;
			for (int i = 0; i < (copy - n) / 5; i++)
				val = val + 33333;
		}
		return val;
	}
}
