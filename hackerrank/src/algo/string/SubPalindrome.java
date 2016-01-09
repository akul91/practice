package algo.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int output = palindrome(str);
		System.out.println(output);
		sc.close();
	}
	 
	static int palindrome(String str) {
		// Using Set to remove duplicates
		Set<String> substrings = new HashSet<String>();
		for (int i = 0; i <= str.length(); i++)
			for (int j = i + 1; j <= str.length(); j++)
				substrings.add(str.substring(i, j));
		int count = 0;
		// Using StringBuffer to reverse string
		for (String s : substrings) {
			if (s.equals(new StringBuffer(s).reverse().toString()))
				++count;
		}
		return count;
	}
}
