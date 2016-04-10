package contest.projectEuler;

import java.util.Scanner;

public class EvenFibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			long n = in.nextLong();
			long first = 0;
			long second = 1;
			long sum = 0;
			for (;;) {
				long third = first + second;
				if (third > n)
					break;
				if (third % 2 == 0)
					sum += third;
				first = second;
				second = third;
			}
			System.out.println(sum);
		}
		in.close();
	}

}
