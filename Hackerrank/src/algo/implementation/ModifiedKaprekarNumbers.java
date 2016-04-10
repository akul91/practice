package algo.implementation;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		boolean flag = true;
		for (int i = p; i <= q; i++) {
			long square = (long) i * (long) i;
			long d = checkDigits(i);
			long right = getRightHand(square, d);
			long left = (long) ((square - right) / Math.pow(10, d));
			if (checkDigits(left) == d || checkDigits(left) == d - 1) {
				if (right + left == i) {
					System.out.print(i + " ");
					flag = false;
				}
			}
		}
		if (flag)
			System.out.print("INVALID RANGE");
		in.close();

	}

	private static long getRightHand(long square, long d) {
		int dividend = (int) Math.pow(10, d);
		long num = square % dividend;
		return num;
	}

	private static int checkDigits(long left) {
		int d = 0;
		while (left != 0) {
			++d;
			left = left / 10;
		}
		return d;
	}

}
