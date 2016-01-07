package algo.string;

import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		int a[] = new int[26];
		for (int i = 0; i < 26; i++) {
			a[i] = 1;
		}
		Scanner sc = new Scanner(System.in);
		char s[] = sc.nextLine().toLowerCase().toCharArray();
		for (int i = 0; i < s.length; i++) {
			int ch = (int) s[i] - 97;
			if (ch >= 0 && a[ch] == 1)
				a[ch] = 0;
		}
		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			if (a[i] == 1) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("pangram");
		else
			System.out.println("not pangram");
		sc.close();
	}

}
