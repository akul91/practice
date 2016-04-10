package algo.string;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			String str = in.next();
			if (str.length() % 2 != 0) {
				System.out.println("-1");
				continue;
			}
			String strA = str.substring(0, str.length() / 2);
			String strB = str.substring(str.length() / 2, str.length());
			int[] aCount = new int[26];
			int[] bCount = new int[26];
			for (int i = 0; i < strA.length(); i++) {
				int val = (int) strA.charAt(i) - 97;
				aCount[val] += 1;
			}
			for (int i = 0; i < strB.length(); i++) {
				int val = (int) strB.charAt(i) - 97;
				bCount[val] += 1;
			}
			int diff = 0;
			for (int i = 0; i < 26; i++) {
				diff += Math.abs(aCount[i] - bCount[i]);
			}
			System.out.println(diff / 2);
		}
		in.close();

	}

}
