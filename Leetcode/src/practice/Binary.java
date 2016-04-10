package practice;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuffer str = new StringBuffer();
		while (n != 0) {
			str.append(n % 2);
			n = n / 2;
		}
		System.out.println(str.reverse());
		System.out.println(addBinary(in.next(), in.next()));
		in.close();
	}

	public static String addBinary(String a, String b) {
		int ptrA = a.length() - 1;
		int ptrB = b.length() - 1;
		int carry = 0;
		StringBuffer str = new StringBuffer();
		while (ptrA >= 0 || ptrB >= 0) {
			int x = 0, y = 0;
			if (ptrA >= 0)
				x = (int) a.charAt(ptrA) - 48;
			if (ptrB >= 0)
				y = (int) b.charAt(ptrB) - 48;
			int sum = x + y + carry;
			if (sum == 0)
				str.append("0");
			else if (sum == 2) {
				carry = 1;
				str.append("0");
			} else {
				str.append("1");
				if (sum > 2)
					carry = 1;
				else
					carry = 0;
			}
			--ptrA;
			--ptrB;
		}
		if (carry == 1)
			str.append("1");
		return str.reverse().toString();
	}
}
