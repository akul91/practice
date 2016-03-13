package practice;

import java.util.Scanner;

public class ValidPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isPalindrome(sc.next()));
		sc.close();
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			while (!isAlphaNumeric(s.charAt(i)))
				i++;
			while (!isAlphaNumeric(s.charAt(j)))
				j--;
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	private static boolean isAlphaNumeric(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		else if ((int) ch >= 48 && (int) ch <= 57)
			return true;
		return false;
	}

}
