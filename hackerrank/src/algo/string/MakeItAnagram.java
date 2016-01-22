package algo.string;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String strA = in.next();
		String strB = in.next();
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
		System.out.print(diff);
		in.close();

	}

}
