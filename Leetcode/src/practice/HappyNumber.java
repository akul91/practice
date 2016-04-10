package practice;

import java.util.Scanner;

public class HappyNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(isHappy(in.nextInt()));
		in.close();
	}

	public static boolean isHappy(int n) {
		while (true) {
			if (n < 10) {
				if (n == 1 || n == 7)
					return true;
				else
					return false;
			}
			int sum = 0;
			if (n == 1)
				return true;
			while (n != 0) {
				int d = n % 10;
				n = n / 10;
				sum += Math.pow(d, 2);
			}
			n = sum;
		}
	}
}
