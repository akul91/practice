package algo.string;

import java.util.Scanner;

public class Gemstones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int chars[] = new int[26];
		for (int i = 0; i < n; i++) {
			String str = in.next();
			int temp[] = new int[26];
			for (int j = 0; j < str.length(); j++) {
				int val = (int) str.charAt(j) - 97;
				if (temp[val] == 0) {
					temp[val] = 1;
					chars[val] += 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (chars[i] == n)
				++count;
		}
		System.out.println(count);
		in.close();
	}

}
