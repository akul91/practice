package practice;

import java.util.Scanner;

public class ImplementStrStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String haystack = sc.next();
		String needle = sc.next();
		System.out.println(strStr(haystack, needle));
		sc.close();
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0 || haystack.equals(needle))
			return 0;
		if (haystack.length() < needle.length())
			return -1;
		if (haystack.length() == needle.length()) {
			for (int i = 0; i < haystack.length(); i++)
				if (haystack.charAt(i) != needle.charAt(i))
					return -1;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int count = 1;
				int pos = i;
				int x = i;
				for (int j = 1; j < needle.length(); j++) {
					if (x + 1 < haystack.length() && haystack.charAt(++x) == needle.charAt(j))
						++count;
					else
						break;
				}
				if (count == needle.length())
					return pos;
			}
		}
		return -1;
	}

}
