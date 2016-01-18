package algo.string;

import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int count = 0;
			StringBuffer str = new StringBuffer(in.next());
			for (int i = 0; i < str.length(); i++) {
				if (i != 0) {
					if (str.charAt(i) == str.charAt(i - 1)) {
						str.delete(i, i);
						++count;
					}
				}
			}
			System.out.println(count);
		}
		in.close();
	}

}
