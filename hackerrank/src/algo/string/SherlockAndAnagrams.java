package algo.string;

import java.util.Scanner;

public class SherlockAndAnagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			String str = in.next();
			int count = 0;
			for (int len = 1; len <= str.length(); len++) {
				for (int i = 0; i < str.length(); i++) {
					for (int k = i + 1; k < str.length() - len + 1; k++) {
						if (checkAnagram(str.substring(i, i + len), str.substring(k, k + len)) == 1)
							++count;
					}
				}
			}
			System.out.println(count);
		}
		in.close();
	}

	public static int checkAnagram(String strA, String strB) {
		int value = 1;
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
		for (int i = 0; i < 26; i++) {
			if (aCount[i] != bCount[i]) {
				value = 0;
				break;
			}
		}
		return value;
	}
}
