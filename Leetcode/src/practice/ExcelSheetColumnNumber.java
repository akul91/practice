package practice;

import java.util.Scanner;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(titleToNumber(in.next()));
		in.close();
	}

	public static int titleToNumber(String s) {
		int val = 0;
		boolean flag = false;
		int power = s.length() - 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int temp = (int) s.charAt(i) - 64;
			if (!flag)
				val = (int) Math.pow(26, power--) * temp;
			else
				val += (int) Math.pow(26, power--) * temp;
			flag = true;
		}
		int temp = (int) s.charAt(s.length() - 1) - 64;
		val += temp;
		return val;
	}
}
