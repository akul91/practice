package practice;

import java.util.Scanner;

public class ZigZagConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(convert(in.next(), 3));
		in.close();
	}

	public static String convert(String s, int numRows) {
		StringBuffer output = new StringBuffer();
		int n = s.length();
		char[][] arr = new char[numRows][n];
		int c = 0;
		int i = 0;
		while (i < s.length()) {
			for (int j = 0; j < numRows; j++) {
				if (i > s.length() - 1)
					break;
				arr[j][c] = s.charAt(i++);
			}
			++c;
			int temp = numRows - 2;
			while (temp > 0) {
				if (i < s.length())
					arr[temp][c] = s.charAt(i++);
				else
					break;
				--temp;
				++c;
			}
		}
		for (i = 0; i < numRows; i++) {
			for (int j = 0; j < n; j++) {
				if ((int) arr[i][j] != 0)
					output.append(arr[i][j]);
			}
		}
		return output.toString();
	}
}
