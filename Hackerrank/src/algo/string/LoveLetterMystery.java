package algo.string;

import java.util.Scanner;

public class LoveLetterMystery {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			String str = in.next();
			int count = 0;
			if (str.length() % 2 != 0) {
				for (int f = 0, b = str.length() - 1; f <= b - 2; f++, b--) {
					count += Math.abs(str.charAt(f) - str.charAt(b));
				}
			} else {
				for (int f = 0, b = str.length() - 1; f <= b - 1; f++, b--) {
					count += Math.abs(str.charAt(f) - str.charAt(b));
				}
			}
			System.out.println(count);
		}
		in.close();
	}
}
