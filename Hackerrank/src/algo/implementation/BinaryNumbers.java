package algo.implementation;

import java.util.Scanner;

public class BinaryNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			StringBuffer num = new StringBuffer();
			while (n != 0) {
				num.append(n % 2);
				n /= 2;
			}
			System.out.println(num.reverse());
		}
		in.close();
	}

}
