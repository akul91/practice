/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.*/
package practice;

import java.util.Scanner;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(convertToTitle(in.nextInt()));
		in.close();
	}

	public static String convertToTitle(int n) {
		int temp = n;
		StringBuffer str = new StringBuffer();
		while (temp > 0) {
			if (temp % 26 == 0)
				str.append("Z");
			else
				str.append((char) (64 + (temp % 26)));
			if (temp % 26 == 0)
				temp = temp / 26 - 1;
			else
				temp = temp / 26;

		}
		return str.reverse().toString();
	}
}
