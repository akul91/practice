package algo.string;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			String str = in.next();
			int index = -1;
			if (str.length() % 2 != 0) {
				for (int f = 0, b = str.length() - 1; f <= b - 2; f++, b--) {
					if (str.charAt(f) != str.charAt(b)) {
						if (str.charAt(f) == str.charAt(b - 1) && str.charAt(f + 1) == str.charAt(b - 2)) {
							index = b;
							break;
						}
						if (str.charAt(f + 1) == str.charAt(b) && str.charAt(f + 2) == str.charAt(b - 1)) {
							index = f;
							break;
						}
					}
				}
			} else {
				for (int f = 0, b = str.length() - 1; f <= b - 1; f++, b--) {
					if (str.charAt(f) != str.charAt(b)) {
						if (str.charAt(f) == str.charAt(b - 1) && str.charAt(f + 1) == str.charAt(b - 2)) {
							index = b;
							break;
						}
						if (str.charAt(f + 1) == str.charAt(b) && str.charAt(f + 2) == str.charAt(b - 1)) {
							index = f;
							break;
						}
					}
				}
			}
			System.out.println(index);
		}
		in.close();

	}

}
