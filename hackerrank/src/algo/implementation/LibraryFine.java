package algo.implementation;

import java.util.Scanner;

public class LibraryFine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ad = sc.nextInt();
		int am = sc.nextInt();
		int ay = sc.nextInt();
		int ed = sc.nextInt();
		int em = sc.nextInt();
		int ey = sc.nextInt();
		int fine = 0;
		if (ay < ey) {
			fine = 0;
		} else if (ay == ey) {
			if (am < em) {
				fine = 0;
			} else if (am == em) {
				if (ad <= ed) {
					fine = 0;
				} else {
					fine = Math.abs(ed - ad) * 15;
				}
			} else
				fine = 500 * Math.abs(em - am);
		} else
			fine = 10000;
		System.out.println(fine);
		sc.close();
	}
}
