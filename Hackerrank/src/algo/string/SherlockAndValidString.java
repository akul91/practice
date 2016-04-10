package algo.string;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndValidString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();

		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int val = (int) str.charAt(i) - 97;
			count[val] += 1;
		}
		Arrays.sort(count);
		int sMax = count[24];
		int diff = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0 && count[i] < sMax)
				++diff;
		}
		if (diff < 2)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
